/**
 * Created by Administrator on 2017/9/2 0002.
 */
public class GuessNum {
    public static int getMoneyAmount(int n) {
        // Write your code here
        if(n < 2) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i < n; i++){
            dp[i][i+1] = i;
        }
        for(int i = n-1; i >= 1; i--){
            for(int j = i+1; j <= n; j++){
                for(int k = i+1; k < j; k++){
                    int tmp = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    dp[i][j] =  k == i+1 ? tmp : Math.min(dp[i][j], tmp);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args){
        int n = 10;
        System.out.println(getMoneyAmount(n));
    }
}
