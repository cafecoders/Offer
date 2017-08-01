package ZUOs;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class ZhuArea {
    public static void main(String[] args){
        int[] arr = {3,4,2,5,6,4,9};
        int l = 0;
        int r = arr.length - 1;
        int sum = 0;
        while(l < r){
            int subSum = Math.min(arr[l], arr[r]) * (r - l - 1);
            if(arr[l] <= arr[r]){
                l++;
            }else{
                r++;
            }
            sum = subSum > sum ? subSum : sum;
        }

        System.out.println(sum);
    }
}
