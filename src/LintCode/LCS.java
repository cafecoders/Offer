package LintCode;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class LCS {
    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null){
            return 0;
        }
        if(A.length() == 0 || B.length() == 0){
            return 0;
        }
        char[] chas1 = A.toCharArray();
        char[] chas2 = B.toCharArray();
        int[][] dp = new int[chas1.length][chas2.length];
        for(int i = 0; i < chas1.length; i++){
            dp[i][0] = chas1[i] == chas2[0] ? 1 : 0;
        }
        for(int j = 0; j < chas2.length; j++){
            dp[0][j] = chas1[0] == chas2[j] ? 1 : 0;
        }
        for(int i = 1; i < chas1.length; i++){
            for(int j = 1; j < chas2.length; j++){
                if(chas1[i] == chas2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[chas1.length-1][chas2.length - 1];
    }

    public static void main(String[] args){

    }
}
