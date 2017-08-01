package ZUOs;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class LargestSubArrayProblem {
    public static int positiveLSA(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int l = 0;
        int r = 0;
        int max = 0;
        int sum = 0;
        while(r < arr.length){
            //sum += arr[r];
            if(sum < target){
                sum += arr[r++];
            }else if(sum > target){
                sum -= arr[l++];
            }else{
                max = Math.max(max, r - l);
                sum -= arr[l++];
            }
        }

        if(sum == target){
            max = Math.max(max, r - l);
        }

        return max;
    }

    public static int equalsLSA(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum - target)){
                max = Math.max(max, i - map.get(sum - target));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return max;
    }

    public static int lessThanLSA(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[] h = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        h[arr.length - 1] = arr[arr.length - 1];
        map.put(arr.length - 1, arr.length - 1);
        for(int i = arr.length - 2; i >= 0; i--){
            if(h[i+1] < 0){
                h[i] = arr[i] + h[i+1];
                map.put(i, map.get(i+1));
            }else{
                h[i] = arr[i];
                map.put(i, i);
            }
        }

        int end = 0;//右边界
        int sum = 0;
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            while(end < arr.length && sum + h[end] <= target){
                sum += h[end];
                end = map.get(end) + 1;
            }
            res = Math.max(res, end - i);
            //一步也没跳，则sum不变， end++；否则sum-arr【i】，end不动
            sum -= end > i ? arr[i] : 0;
            end = Math.max(end, i+1);
        }
        return res;

    }


    public static void main(String[] args){
        int[] arr = {1,2,1,1,1};
        int[] arr2 = {3, -2, -4, 0, 6};
        System.out.println(positiveLSA(arr, 3));
        System.out.println(lessThanLSA(arr2, -2));
    }


}
