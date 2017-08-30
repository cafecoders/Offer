package HUAWEI;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class QuanPaiLie {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};
        permute(nums, 0);
    }

    public static void permute(int[] nums, int start){
        if(start == nums.length - 1){
            printArr(nums);
        }else
            for(int i = start; i < nums.length; i++){
                swap(nums, start, i);
                permute(nums, start + 1);
                swap(nums, start, i);
            }
    }

    public static void printArr(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.print(" ");
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
