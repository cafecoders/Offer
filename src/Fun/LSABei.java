package Fun;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class LSABei {
    public static void main(String[] args){
       /* Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long[] arr = new long[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        long k = sc.nextInt();*/
        int[] arr  = {6,2,7,8,4,8,2,6,7,7};
        int k = 4;
        int maxSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSum += arr[i];
        }
        for (int j = k; j <= maxSum; j += k) {
            int leng = maxLength(arr, j);
            count = leng > count ? leng : count;

        }
        System.out.println(count);
    }

    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
