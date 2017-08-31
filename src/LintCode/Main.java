package LintCode;

/**
 * Created by missinghigh on 2017/8/30.
 */
public class Main {
    public static  void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                Right();
            }
        };
        t.start();
        System.out.println("left");
    }

    static  void Right(){
        System.out.println("right");
    }
}
