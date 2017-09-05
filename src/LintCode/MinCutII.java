package LintCode;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class MinCutII {
    public static int minCut(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                dp[i][i+1] = 1;
            }
        }
        for(int i = n-3; i >= 0; i--){
            for(int j = i+2; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static int minCut2(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] count = new int[n];
        for(int i = 0; i < n; i++){
            count[i] = n-1 - i;
        }
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n-1; j++){
                if(s.charAt(i) == s.charAt(j) && (j <= i+1 || dp[i+1][j-1])){
                    count[i] = Math.min(count[i], count[j+1] + 1);
                }
            }
        }
        return count[0];
    }

    public static boolean canPartition(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if((sum & 0x1) == 1){
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= 0; j--){
                if(j >= nums[i])
                    dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }


    public static void main(String[] args){
        String s = "ababbbabbaba";
        int[] nums = {1,5,5,11};
        System.out.println(minCut2(s));
        System.out.println(canPartition(nums));
    }

}
