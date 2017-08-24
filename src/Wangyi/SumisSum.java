package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class SumisSum {
    public static long getNum(int[] arr, int k){
        int len = arr.length;
        long[] dp = new long[k+1];


        dp[0] = 1;
        if(arr[0] <= k)
             dp[arr[0]] = 1;
        for(int i = 1; i < len; i++){
            for(int j = k; j >= 1; j--){
                dp[j] = dp[j] + (j >= arr[i] ? dp[j-arr[i]] : 0);
            }
        }

        return dp[k]; //5 15 2 3 5 5 10
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(getNum(arr, k));
    }
}
