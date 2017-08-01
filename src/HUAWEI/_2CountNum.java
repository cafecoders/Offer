package HUAWEI;

import java.util.Scanner;

/**
 * Created by missinghigh on 2017/8/1.
 */
public class _2CountNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(countNum(str1, str2));
    }

    public static int  countNum(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int count = 0;
        for(int i = 0; i < chas1.length; i++){
            if(chas1[i] == chas2[0]){
                count++;
            }
        }
        return count;
    }
}
