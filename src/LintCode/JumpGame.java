package LintCode;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
public class JumpGame {
    public boolean canJump(int[] arr){
        if(arr == null || arr.length == 0){
            return false;
        }
        int n = arr.length;
        //int[] next = new int[n];
        int next = arr[0];
        for(int i = 1; i < n; i++){
            if(i > next){
                return false;
            }
            next = Math.max(arr[i] + i, next);
        }
        return true;
    }
}
