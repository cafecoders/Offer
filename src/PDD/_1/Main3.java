package PDD._1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class Main3 {
    public static int getMaxLittleFriend(int[] cho, int[] lf){
        int clen = cho.length;
        int llen = lf.length;
        Arrays.sort(cho);
        Arrays.sort(lf);
        int[][] dp = new int[clen][llen];
        for(int i = 0; i < clen; i++){
            if(cho[i] >= lf[0]){
                dp[i][0] = 1;
                while(i < clen){
                    dp[i++][0] = 1;
                }
                break;
            }
        }
        for(int j = 0; j < lf.length; j++){
            if(cho[0] >= lf[j]){
                dp[0][j] = 1;
                while(j < llen){
                    dp[0][j++] = 1;
                }
                break;
            }
        }


        int max = Integer.MIN_VALUE;

        for(int i = 1; i < clen; i++){
            for(int j = 1; j < llen; j++){
                if(cho[i] >= lf[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
                max = dp[i][j] > max ? dp[i][j] : max;
            }
        }

        return max;
    }

    public static void main(String[] args){
       /* int[] cho = {3,1};
        int[] lf = {2,3,2};*/
        Scanner sc = new Scanner(System.in);
        int llen = sc.nextInt();
        int[] lf = new int[llen];
        for(int i = 0; i < llen; i++){
            lf[i] = sc.nextInt();
        }
        int clen = sc.nextInt();
        int[] cho = new int[clen];
        for(int i = 0; i < clen; i++){
            cho[i] = sc.nextInt();
        }
        System.out.println(getMaxLittleFriend(cho, lf));
    }
}
