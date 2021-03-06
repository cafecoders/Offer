package hotSwap;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class MyClassLoader extends ClassLoader{
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        try{
            String fileName = name.substring(name.lastIndexOf("." )+1) + ".class" ;
            InputStream is = this.getClass().getResourceAsStream(fileName);
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b. length);
        } catch(IOException e){
            throw new ClassNotFoundException(name);
        }
    }
}