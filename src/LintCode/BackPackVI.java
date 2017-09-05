package LintCode;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class BackPackVI {
    public static int backPackVI(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j <= target; j++){
            dp[0][j] = j%nums[0] == 0 ? 1 : 0;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
                dp[i][j] = dp[i-1][j] + ((j >= nums[i]) ? dp[i][j-nums[i]] : 0);
                /*if(j >= nums[i]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }*/
            }
        }
        return dp[n-1][target];
    }

    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 4};
        int target = 4;
        System.out.println(backPackVI(nums, target));
        System.out.println(coins4(nums, target));
    }
}
