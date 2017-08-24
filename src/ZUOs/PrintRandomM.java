package ZUOs;

import java.util.Random;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class PrintRandomM {
    public static void printRandomM(int[] arr, int M){
        if(arr == null || arr.length == 0 || arr.length < M){
            return;
        }
        int len = arr.length;
        for(int i = 0; i < M; i++){
            int index = new Random().nextInt(len);
            System.out.print(arr[index] + " ");
            swap(arr, index, len-1);
            len--;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        printRandomM(arr, 5);
    }
}
