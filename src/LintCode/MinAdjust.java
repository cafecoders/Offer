package LintCode;

import Wangyi.InaRest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class MinAdjust {
    public static int minAdjust(ArrayList<Integer> A, int target){
        if(A == null || A.size() == 0){
            return 0;
        }
        int[] arr = new int[A.size()];
        int max = A.get(0);
        for(int i = 0; i < A.size(); i++){
            arr[i] = A.get(i);
            max = A.get(i) >  max ? arr[i] : max;
        }

        int[][] dp = new int[arr.length][max+1];
        for(int j = 0; j < max+1; j++){
            dp[0][j] = Math.abs(j - arr[0]);
        }
        int min = 0;
        for(int i = 1; i < arr.length; i++){
            min = Integer.MAX_VALUE;
            for(int j = 0; j < max + 1; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = Math.max(j - target, 0); k <= Math.min(j + target, max); k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(arr[i] - j));
                }
                min = dp[i][j] < min ? dp[i][j] : min;
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] arr = {1,4,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        System.out.println(minAdjust(list, 1));
    }

}
