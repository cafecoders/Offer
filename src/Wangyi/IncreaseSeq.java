package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class IncreaseSeq {
    static int pick(int[] peaches) {
        int[] dp = new int[peaches.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < peaches.length; i++){
            for(int j = 0; j < i; j++){
                if(peaches[j] <= peaches[i])
                    dp[i] = Math.max(dp[j] + 1, 1);
                else
                    dp[i] = 1;
            }
            max = dp[i] > max ? dp[i] : max;
         }
        return max;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        //int[] peaches = {10,4,5,12,8};
        System.out.println(pick(peaches));
    }
}
