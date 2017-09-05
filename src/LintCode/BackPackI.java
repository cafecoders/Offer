package LintCode;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class BackPackI {
    public static int backPack(int m, int[] arr) {
        int[][] dp = new int[arr.length][m+1];
        for(int j = 1; j < m+1; j++){
            if(arr[0] <= j)
                dp[0][j] = arr[0];
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < m+1; j++){
                if(arr[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i]] + arr[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length - 1][m];
    }

    public static int backPackII(int m, int[] A, int[] V) {
        int[][] dp = new int[A.length][m+1];
        for(int j = 1; j < m+1; j++){
            if(A[0] <= j)
                dp[0][j] = V[0];
        }
        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < m+1; j++){
                if(A[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i]] + V[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[A.length - 1][m];
    }

    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j <= target; j++){
            dp[0][j] = j%nums[0] == 0 ? 1 : 0;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
                dp[i][j] = dp[i-1][j] + j >= nums[i] ? dp[i][j-nums[i]] : 0;
            }
        }
        return dp[n-1][target];
    }

    public int backPackVI2(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];

        for(int j = 0; j*nums[0] <= target; j++ ){
            dp[j*nums[0]] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= target; j++){
                dp[j] += dp[j-nums[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args){
        int[] arr = {3,4,8,5};
        int m = 10;
        System.out.println(backPack(m, arr));
        int[] A = {2,3,5,7};
        int[] V = {1,5,2,4};
        System.out.println(backPackII(10, A, V));
    }
}
