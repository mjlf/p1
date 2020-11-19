import com.mjlf.bytebuddy.Outer;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2020/5/26 11:08
 * @Version 1.0
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType = new ByteBuddy()
                .with(new NamingStrategy.AbstractBase() {
                    @Override
                    protected String name(TypeDescription typeDescription) {
                        return "i.love.ByteBuddy.";
                    }
                }).subclass(Outer.class)
                .name("xxxx")
                .defineField("a", Integer.TYPE, 1)
                .defineField("b", Integer.TYPE, 2)
                .make()
                .load(Test.class.getClassLoader())
                .getLoaded();


        Outer outer = (Outer) dynamicType.newInstance();
        System.out.println(outer.toString());
        outer.show();
    }
}
