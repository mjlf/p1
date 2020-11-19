package com.mjlf.skywalking;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @ClassName NacosTest
 * @Author mjlft
 * @Date 2020/8/5 20:39
 * @Version 1.0
 * @Description TODO
 */
public class NacosTest {
    public static void main(String[] args) {
        try {
            String serverAddr = "192.168.43.195:32006";
            String dataId = "example";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
