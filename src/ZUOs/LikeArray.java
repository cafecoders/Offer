package ZUOs;

/**
 * Created by missinghigh on 2017/8/30.
 */
public class LikeArray {
    public static int solution1(int n, int k){
        return process1(1, n, k);
    }

    public static int process1(int pre, int n, int k){
        if(n == 0){
            return 1;
        }
        int sum = 0;
        for(int cur = pre; cur <= k; cur++){
            sum += process1(cur, n-1, k);
        }
        for(int cur = 1; cur < pre; cur++){
            sum += (pre % cur != 0) ? process1(cur, n-1, k) : 0;
        }
        return sum;
    }

    public static int solution2(int n, int k){
        int[][] dp = new int[n][k+1];
        for(int j = 0; j < k+1; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < k+1; j++){
                for(int y = 1; y < k+1; y++){
                    dp[i][j] += dp[i-1][y];
                }
                for(int x = 1; x < j; x++){
                    dp[i][j] -= (j % x == 0) ? dp[i-1][x] : 0;
                }

            }
        }
        int sum = 0;
        for(int j = 1; j < k+1; j++){
            sum += dp[n-1][j];
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(solution1(4,4));
        System.out.println(solution2(4,4));
    }
}
