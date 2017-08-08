package PDD._1;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        long[] arr = new long[len];
        for(int i = 0; i < len; i++){
            arr[i] = in.nextLong();
        }

        System.out.println(getMax(arr));
    }

    public static long getMax(long[] arr){
        if(arr == null || arr.length < 3){
            return 0;
        }
        long max1 = arr[0], max2= arr[0], min1= arr[0], min2= arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max1){
                max1 = arr[i];
            }
            if(arr[i] < min1){
                min1 = arr[i];
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max2 && arr[i] != max1){
                max2 = arr[i];
            }
            if(arr[i] < min1 && arr[i] != min1){
                min2 = arr[i];
            }
        }

        long max1_max2 = max1 * max2;
        long min1_min2 = min1 * min2;
        long max1_min1 = max1 * min1;

        long res = 0;
        for(int i = 0; i < arr.length; i++){
            long res1 = 1;
            long res2 = 1;
            long res3 = 1;
            if(arr[i] != max1 && arr[i] != max2){
                res1 = arr[i] * max1_max2;
            }
            if(arr[i] != min1 && arr[i] != min2){
                res2 = arr[i] * min1_min2;
            }
            if(arr[i] != max1 && arr[i] != min1){
                res3 = arr[i] * max1_min1;
            }
            res = Math.max(res, res1);
            res = Math.max(res, res2);
            res = Math.max(res, res3);
        }

        return res;
    }

}
