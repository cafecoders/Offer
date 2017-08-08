package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _14PasswordProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            System.out.print(isCorrect(str) + " ");
        }
    }

    public static String isCorrect(String str){
        if(str == null || str.length() < 8){
            return "NG";
        }
        char[] chas = str.toCharArray();
        int numN = 0, numL = 0, numS = 0, numE = 0;
        for(int i = 0; i < chas.length; i++){
            if(isNum(chas[i])){
                numN = 1;
            }else if(isLarge(chas[i])){
                numL = 1;
            }else if(isSmall(chas[i])){
                numS = 1;
            }else{
                numE = 1;
            }
        }
        if(numE + numL + numN + numS < 3){
            return "NG";
        }
        return checkCharRepeat(str) ? "NG" : "OK";

    }

    public static boolean checkCharRepeat(String password){
        for(int i=0 ;i < password.length()-2 ;i++){
            String substr1 =password.substring(i, i+3);
            if (password.substring(i+1).contains(substr1))
                return true;
        }
        return false;
    }

    public static boolean isNum(char c){
        if(c <= '9' && c >= '0'){
            return true;
        }
        return false;
    }

    public static boolean isLarge(char c){
        if(c <= 'Z' && c >= 'A'){
            return true;
        }
        return false;
    }

    public static boolean isSmall(char c){
        return (c <= 'z' && c >= 'a') ? true : false;
    }
}
