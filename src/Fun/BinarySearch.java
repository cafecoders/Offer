package Fun;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class BinarySearch {
    public static int bs(int[] arr, int key){
        int l = 0;
        int r = arr.length - 1;
        while(l < r){
            int mid = (l + r)/2;
            if(arr[mid] > key){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return arr[l];
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int key = 4;
        System.out.println(bs(arr, key));
    }
}
