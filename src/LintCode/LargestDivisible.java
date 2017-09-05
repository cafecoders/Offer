package LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
public class LargestDivisible {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        dp[0] = 1;
        int max = nums[0], index = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            pre[i] = -1;
            for(int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    //dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] <= dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }

        while(index != -1){
            list.add(nums[index]);
            index = pre[index];
        }

        return list;
    }

    public static void main(String[] args){
        int[] arr = {1,2,4,8};

        System.out.println(largestDivisibleSubset(arr));
    }
}
