package LintCode;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
public class CoinsInLine {
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return false;
        }
        int len = values.length;
        int[] dp = new int[len];
        int[] sums = new int[len];
        sums[len - 1] = values[len - 1];
        for(int i = len - 2; i >= 0; i--){
            sums[i] = sums[i+1] + values[i];
        }
        if(len < 3){
            return true;
        }
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 1] + values[len - 2];
        for(int i = len - 3; i >= 0; i--){
            dp[i] = Math.max(values[i] + sums[i+1] - dp[i+1], values[i] + values[i+1] + sums[i+2] - dp[i+2]);
        }
        return dp[0] > sums[0]/2 ? true : false;
    }
}
