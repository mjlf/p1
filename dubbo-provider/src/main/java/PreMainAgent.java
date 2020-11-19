import java.lang.instrument.Instrumentation;

/**
 * @ClassName PreMainAgent
 * @Author mjlft
 * @Date 2020/5/25 20:55
 * @Version 1.0
 * @Description TODO
 */
public class PreMainAgent {
    public static void premain(String agentParam, Instrumentation ins){
        System.out.println("执行： " + agentParam);
    }
}
