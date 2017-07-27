package minK;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k || k < 1) {
            return list;
        }
        int[] kHeap = new int[k];
        for(int i = 0; i < k; i++){
            //heapInsert(kHeap, input[i], i);
            kHeap[i] = input[i];
        }
        heapify(kHeap);
        for(int i = k; i < input.length; i++){
            if(input[i] < kHeap[0]){
                kHeap[0] = input[i];
                heapify(kHeap);
            }
        }
        for(Integer i : kHeap){
            list.add(i);
        }

        return list;
    }


    public static void adjustHeap(int[] arr, int pos, int len){

            int child;
            while(2*pos + 1 <= len){ // 判断是否到达最下层
                child = 2*pos + 1;
                if(child < len && arr[child]  < arr[child+1]) // 寻找最大子节点
                    child++;

                if(arr[pos] < arr[child])
                    swap(arr, pos, child);   // 若父节点较小，交换
                else
                    break;

                pos = child;  // 重置标志，往下重复到最下层
            }
    }

    public static void heapify(int[] arr){
        int len = arr.length;

        int pos = len/2 - 1;
        for(int i = pos; i >=0; i--){
            adjustHeap(arr, i, len-1);
        }

        /*for(int i = len-1; i>=0; i--){
            swap(arr, 0, i);
            adjustHeap(arr, 0, i-1);
        }*/
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {4,5,1,9,6,2,7,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 4);
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }

}
