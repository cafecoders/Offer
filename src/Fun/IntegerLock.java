package Fun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by missinghigh on 2017/8/27.
 */
public class IntegerLock {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yy:MM:ss HH:mm:ss");
    public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
    public static class ParseDate implements Runnable{
        int i = 0;
        public ParseDate(int i){this.i = i;}
        public void run(){
            try {
                    if(threadLocal.get() == null){
                        threadLocal.set(new SimpleDateFormat("yy:MM:ss HH:mm:ss"));
                    }
                    Date t = threadLocal.get().parse("2015:03:29 19:29:" + i%60);
                    System.out.println(i + ":" + t);



            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 1000; i++){
            es.execute(new ParseDate(i));
        }
    }
}
