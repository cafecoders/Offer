package Wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class Cooker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(isContained(str1, str2));
        }

    }

    public static String isContained(String str1, String str2){
        if(str2.length() > str1.length()){
            return "No";
        }
        int i = 0;
        int j = 0;
        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i++) == str2.charAt(j)){
                j++;
            }
        }
        if(j == str2.length()){
            return "Yes";
        }
        return "No";
    }
}
