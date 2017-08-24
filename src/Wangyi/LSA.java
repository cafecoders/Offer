package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class LSA {
    public static long largestSubArray(int[] arr){
        if(arr == null ||arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(largestSubArray(arr));
    }
}
