package LintCode;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class MinTotal {
    public static int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0 || triangle[0].length ==0)
            return 0;

        int row = triangle.length;
        int col = triangle.length;
        int[][] dp = new int[row][col];

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][triangle[i].length-1] = dp[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];
        }



        for(int i = 1; i < row; i++)
            for(int j = 1; j < triangle[i].length-1; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }

        int min = dp[row-1][0];
        for(int i = 1; i < col; i++)
            min = Math.min(min, dp[row-1][i]);

        return min;
    }

    public int uniquePaths(int m, int n) {
        // write your code here
        if(m < 1 || n < 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j  = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        dp[0][0] = obstacleGrid[0][0];
        for(int i = 1; i < rows; i++){
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }
        for(int j = 1; j < cols; j++){
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j-1];
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args){
        int[][] triangle = {{-1},{2,3},{1,-1,-3}};
        System.out.println(minimumTotal(triangle));
    }
}
