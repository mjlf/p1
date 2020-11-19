import com.mjlf.interceptor.MyInterceptor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * @ClassName PreMainAgent
 * @Author mjlft
 * @Date 2020/5/25 20:55
 * @Version 1.0
 * @Description 测试java agent 在执行业务方法前， 会执行一些其他业务逻辑
 */
public class PreMainAgent {
    public static void premain(String agentParam, Instrumentation ins){
        System.out.println("执行： " + agentParam);
        AgentBuilder.Transformer transformer = new AgentBuilder.Transformer() {
            @Override
            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                //method 指定哪些方法被拦截
                return builder
                        .method(ElementMatchers.<MethodDescription>any())
                        .intercept(MethodDelegation.to(MyInterceptor.class));
            }
        };

        //type指定agent拦截的报名，以com.mjlf作为前缀
        //指定了transform转换器
        //将配置安装到Instrumentation
        new AgentBuilder
                .Default()
                .type(ElementMatchers.<TypeDescription>nameStartsWith("com.mjlf"))
                .transform(transformer)
                .installOn(ins);
    }
}
