package com.mjlf.nacosprovider.controller;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.mjlf.nacosprovider.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/get")
    public String get() {
        try(Entry entity = SphU.entry("get")){
            return applicationContext.getEnvironment().getProperty("abc.text") + applicationContext.getEnvironment().getProperty("abc.name");
        }catch (Exception e){
            e.printStackTrace();
            return "降级处理";
        }
    }

    @RequestMapping("/bool")
    public String bool() {
        if(SphO.entry("bool")){
            try{
                System.out.println("yes");
                return "yes";
            }finally {
                SphO.exit();
            }
        }else {
            return "no";
        }
    }

    @RequestMapping("/asnyc")
    public String asnyc() {
        AsyncEntry asyncEntry = null;
        try {
            asyncEntry = SphU.asyncEntry("async");
            return asyncService.abc();
        } catch (BlockException e) {
            return "no";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "异常";
        } finally {
            if (asyncEntry != null){
                asyncEntry.exit();
            }
        }
    }

    @SentinelResource(value = "diyRes", blockHandler = "exceptionDiyRes")
    @RequestMapping("/diyRes")
    public String diyRes() {
        return "正常";
    }

    public String exceptionDiyRes(BlockException e){
        e.printStackTrace();
        return "异常";
    }

//    @PostConstruct
//    public void initFlowRules(){
//        //1.创建规则存储集合
//        List<FlowRule> rules = new ArrayList<>();
//        //2.创建规则
//        FlowRule rule = new FlowRule();
//        //3.定义规则资源，表示sentienl对那个资源生效
//        rule.setResource("get");
//        //4.定义资源规则类型，
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        //5.定义规则值
//        rule.setCount(2);
//        //6.添加规则到集合
//        rules.add(rule);
//        //7.加载规则集合
//        FlowRuleManager.loadRules(rules);
//    }

}