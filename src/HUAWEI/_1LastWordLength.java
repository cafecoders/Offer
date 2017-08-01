package HUAWEI;

import java.util.Scanner;

/**
 * Created by missinghigh on 2017/8/1.
 */
public class _1LastWordLength {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        System.out.println(strs[strs.length - 1].length());
    }
}
