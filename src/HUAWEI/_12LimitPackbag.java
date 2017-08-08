package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _12LimitPackbag {
    public static int getMaxSum(int num, int total, int[] weight, int[] value, int[] isZhu){
        int[][] dp = new int[num+1][total+1];//dp[i][j]表示用j的钱去买i件商品的最大价值
        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= total; j++){
                if(isZhu[i-1] == 0){
                    if(weight[i-1] <= j){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1]] + value[i-1]);
                    }
                }else{
                    if(weight[i-1] + weight[isZhu[i-1]] <= j){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1] - weight[isZhu[i-1]]] + value[i-1] + value[isZhu[i-1]]);
                    }
                }
            }
        }

        return dp[num][total];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int total = sc.nextInt();
            int num = sc.nextInt();
            int[] weight = new int[num];
            int[] value = new int[num];
            int[] isZhu = new int[num];
            for(int i = 0; i < num; i++){
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt() * weight[i];
                isZhu[i] = sc.nextInt();
            }
            System.out.println(getMaxSum(num, total, weight, value, isZhu));
        }
    }
}
