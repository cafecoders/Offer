package Fun;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class LSA {


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11);
        }
        return result;
    }

    /*public static int maxLength(int[] arr, long k) {
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
    }*/

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

    public static void main(String[] args) {
        int[] arr = generateArray(100);
        //int[] arr = {6,2,7,8,4,8,2,6,7,7};
        int k = 343;
        printArray(arr);
        int[] sum = new int[arr.length + 1];
        sum[0] = 0;
        for(int i = 0; i < arr.length; i++){
            sum[i+1] = sum[i] + arr[i];
        }
        int maxlen = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length + 1; j++){
                if((sum[j] - sum[i]) % k == 0){
                    maxlen = (j - i > maxlen) ? (j - i) : maxlen;
                }
            }
        }

        System.out.println(maxlen);

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
}
