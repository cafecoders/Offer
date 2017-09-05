package LintCode;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class LICS {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        return Math.max(process(A), process(reverse(A)));
    }

    public int process(int[] A){
        int[] dp = new int[A.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                dp[i] = A[i] >= A[j] ? dp[j] + 1 : 1;
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    public int[] reverse(int[] arr){
        for(int i = 0, j = arr.length - 1; i < j; i++, j--){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
}
