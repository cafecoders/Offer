package hotSwap;
import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class HotSwap {
    public static void main(String[] args) throws Exception {
        loadHelloWorld();
        // 回收资源,释放HelloWorld.class文件，使之可以被替换
        System. gc();
        Thread. sleep(1000);// 等待资源被回收
        File fileV2 = new File( "HelloWorld.class");
        File fileV1 = new File(
                "bin\\com\\csair\\soc\\hotswap\\HelloWorld.class" );
        fileV1.delete(); //删除V1版本
        fileV2.renameTo(fileV1); //更新V2版本
        System. out.println( "Update success!");
        loadHelloWorld();
    }

    public static void loadHelloWorld() throws Exception {
        MyClassLoader myLoader = new MyClassLoader(); //自定义类加载器
        Class<?> class1 = myLoader
                .findClass( "com.csair.soc.hotswap.HelloWorld");//类实例
        Object obj1 = class1.newInstance(); //生成新的对象
        Method method = class1.getMethod( "say");
        method.invoke(obj1); //执行方法say
        System. out.println(obj1.getClass()); //对象
        System. out.println(obj1.getClass().getClassLoader()); //对象的类加载器
    }
}
