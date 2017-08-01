package ZUOs;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class WaterProblem {
    public static void main(String [] args){
        int[] arr = {5,4,6,8,2,3,7};
        int l = 0;
        int r = arr.length -1;
        int lm = arr[0];
        int rm = arr[arr.length - 1];
        int sum = 0;

        while(l < r){
            if(arr[l] <= arr[r]){
                sum += lm - arr[l];
                l++;
                lm = arr[l] > lm ? arr[l] : lm;
            }else{
                sum += rm - arr[r];
                r--;
                rm = arr[r] > rm ? arr[r] : rm;
            }
        }

        System.out.println(sum);
    }

}
