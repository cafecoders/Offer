package MinNumInRotateArr;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static int minNumberInRotateArray(int [] array) {
        int len = array.length;
        int left = 0;
        int right = len - 1;
        int mid = left;

        while(array[left] >= array[right]){
            if(right - left == 1){
                mid = right;
                break;
            }

            mid = (left + right)/2;

            if(array[mid] == array[left] && array[mid] == array[right]){
                minInOrder(array, left, right);
            }
            if(array[mid] >= array[left])
                left = mid;
            else if(array[right] >= array[mid])
                right = mid;

        }
        return array[mid];
    }

    public static int minInOrder(int[] numbers, int left, int right){
        int res = numbers[left];
        for(int i = left; i <= right; i++){
            if(res < numbers[i]){
                res = numbers[i];
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {3,3,3,3,1};
        System.out.println(minNumberInRotateArray(arr));
    }
}
