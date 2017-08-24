package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/19 0019.
 */
public class EndZero {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n != 0){
            count += n/5;
            n /= 5;
        }
        System.out.println(count);
    }
}
