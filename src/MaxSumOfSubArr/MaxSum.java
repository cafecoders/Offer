package MaxSumOfSubArr;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class MaxSum {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++){
            dp[i] = Math.max(array[i], array[i] + dp[i-1]);
            max = dp[i] > max ? dp[i] : max;
        }

        return  max;
    }

    public static void main(String[] args){
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
