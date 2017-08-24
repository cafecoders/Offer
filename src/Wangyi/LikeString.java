package Wangyi;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class LikeString {
    public static void main(String[] args){
        String str = "ABCBA";
        if(noABABSubS(str) && isAllUppercase( str) && hasConsecutiveC(str)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

    public static boolean isAllUppercase(String str){
        return str.matches("[A-Z]+");
    }

    public static boolean hasConsecutiveC(String str){
        return !str.matches(".*(.)(\\1).*");
    }

    public static boolean noABABSubS(String str){
        return !str.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}
