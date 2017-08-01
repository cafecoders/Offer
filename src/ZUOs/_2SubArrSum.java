package ZUOs;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class _2SubArrSum {
    public static void main(String[] args){
        int[] arr = {3, -2, 1, -6, 4, 2, -2, 3};
        int [] dp = new int[arr.length];
        dp[0] = arr[0];
       // int[] dpL = subArrSumFromL(arr);
        int[] dpR = subArrSumFromR(arr);
        int maxSum = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
           int sum = (dp[i] = dp[i-1] < 0 ? arr[i] : dp[i-1] +arr[i])  + dpR[i] - arr[i];
            maxSum = sum > maxSum ? sum : maxSum;
        }

        System.out.println(maxSum);
    }

    public static int[] subArrSumFromL(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            dp[i] = dp[i-1] < 0 ? arr[i] : arr[i] + dp[i-1];
        }

        return dp;
    }

    public static int[] subArrSumFromR(int[] arr){
        int[] dp = new int[arr.length];
        dp[arr.length-1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            dp[i] = dp[i+1] < 0 ? arr[i] : arr[i] + dp[i+1];
        }

        return dp;
    }

}
