package Wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class SumGame {
    public static int getSamllestNum(int[] arr){
        Arrays.sort(arr);
        int sum = arr[0];
        if(sum > 1){
            return 1;
        }
        for(int i = 1; i < arr.length; i++){
            if(sum < arr[i]-1){
                return sum+1;
            }else{
                sum += arr[i];
            }
        }

        return sum+1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getSamllestNum(arr));
    }
}
