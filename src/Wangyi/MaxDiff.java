package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class MaxDiff {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getMaxDiff(arr));
    }
    public static int getMaxDiff(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int len = arr.length;
        int l = 0, r= len-2;
        int L = arr[len-1];
        int R = arr[len-1];
        int sum = 0;
        while(l <= r){
            int l_L = Math.abs(arr[l] - L);
            int l_R = Math.abs(arr[l] - R);
            int r_L = Math.abs(arr[r] - L);
            int r_R = Math.abs(arr[r] - R);

            if(l_L >= max(l_R, r_L, r_R)){
                sum += l_L;
                L = arr[l++];
            }
            else if(l_R >= Math.max(r_L, r_R)){
                sum += l_R;
                R = arr[l++];
            }
            else if(r_L >= r_R){
                sum += r_L;
                L = arr[r--];
            }
            else {
                sum += r_R;
                R = arr[r--];
            }
        }

        return sum;
    }

    public static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

}
