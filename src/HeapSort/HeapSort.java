package HeapSort;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class HeapSort {
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

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapSort(int[] arr){
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

    public static void main(String[] args){
        int[] arr = {4,5,1,9,3,7,6,1,8,7};
        heapSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
