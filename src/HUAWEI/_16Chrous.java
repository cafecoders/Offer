package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _16Chrous {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] strs = sc.nextLine().split(" ");
            int[] arr = new int[strs.length];
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(strs[i]);
            }

            int[] dpl = LSC(arr, true);
            int[] dpr = LSC(arr, false);
            int max = 0;
            for(int i = 0; i < dpr.length; i++){
                max = Math.max(max, dpl[i] + dpr[i]);
            }
            System.out.println(arr.length - max + 1);

        }
    }

    public static int[] LSC(int[] arr, boolean flag){
        if(arr == null || arr.length == 0){
            return null;
        }
        int[] dp = new int[arr.length];
        if(flag){
            dp[0] = 1;
            for(int i = 1; i < arr.length; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(arr[j] < arr[i]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }else {
            dp[arr.length - 1] = 1;
            for(int i = arr.length - 2; i >= 0; i--){
                dp[i] = 1;
                for(int j = arr.length - 1; j > i; j--){
                    if(arr[j] < arr[i]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp;
    }
}
