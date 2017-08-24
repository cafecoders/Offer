package Wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/20 0020.
 */
public class PrimePattern {
    public static void main(String[] ags){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 2; i < 1000; i++){
            if(isPrime(i)){
                set.add(i);
            }
        }
        int count = 0;
        for(int i = 2; i <= n/2; i++){
            if(isPrime(i) && isPrime(n-i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int n){
        for(int i = 2; i < n/2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}
