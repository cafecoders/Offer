package MergeStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import ListNode.ListNode;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder("");
        for(String str : list){
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main2(String[] args){
        int[] arr = {3, 32, 321};
        System.out.println(PrintMinNumber(arr));
    }

    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //int[] map = new int[256];
        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }

        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }

        return 0;
    }


/*
*  public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
			return -1;

		char[] chas = str.toCharArray();
		int[] map = new int[256];
		int index;

		for(int i = 0; i < chas.length; i++){
			index = (int)(chas[i]);
			map[index]++;
		}


		int i = 0;
		for( ;i < chas.length && map[(int)(chas[i])] != 1; i++){

		}

		return i == chas.length ? -1 : i;
    }
* */

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = pHead1, cur2 = pHead2;
        while(pHead1 != null){
            pHead1 = pHead1.next;
            len1++;
        }
        while(pHead2 != null){
            pHead2 = pHead2.next;
            len2++;
        }
        int diff = Math.abs(len1 - len2);

        pHead1 = cur1;
        pHead2 = cur2;
        if(len1 > len2){
            while(diff != 0){
                pHead1= pHead1.next;
                diff--;
            }
        }else{
            while (diff != 0){
                pHead2 = pHead2.next;
                diff--;
            }
        }
        pHead1 = cur1;
        pHead2 = cur2;
        while(pHead1 != null){
            if(pHead1.val == pHead2.val){
                return pHead1;
            }else{
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }

       return pHead1;
    }



    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0, right = array.length - 1;
        int mid = (left + right)/2;
        int indexL = -1;
        int indexR = -1;
        while(left < right){
            if(array[mid] < k){
                left = mid;
            }else if(array[mid] > k){
                right = mid;
            }else {
                if(mid > 0 && array[mid-1] == k){
                    right = mid;
                }else{
                    indexL = mid;
                    break;
                }
            }
            mid = (left + right)/2;
        }

        left = 0; right = array.length - 1;
        while(left < right){
            if(array[mid] > k){
                left = mid;
            }else if(array[mid] < k){
                right = mid;
            }else {
                if(mid > 0 && array[mid+1] == k){
                    left = mid;
                }else{
                    indexR = mid;
                    break;
                }
            }
            mid = (left + right)/2;
        }

        return indexR - indexL;
    }

    public static int GetNumberOfK2(int [] arr , int k) {
        if(arr == null || arr.length == 0)
            return 0;

        //int first = getFirstRecur(arr, k, 0, arr.length-1);
        // int last = getLastRecur(arr, k, 0, arr.length-1);

        int first = getFirst(arr, k);
        int last = getLast(arr, k);

        if(first == -1 || last == -1)
            return 0;

        return last - first + 1;
    }

    public static  int getFirstRecur(int[] arr, int k, int start, int end){
        if(start > end)
            return -1;

        int mid = (start + end)/2;
        if(arr[mid] == k){
            if((mid >= 1 && arr[mid-1] != k) || mid == 0)
                return mid;
            else
                end = mid - 1;

        }else if(arr[mid] > k)
            end = mid - 1;
        else
            start = mid + 1;

        return getFirstRecur(arr, k, start, end);
    }

    public static int getLastRecur(int[] arr, int k, int start, int end){
        if(start > end)
            return -1;

        int mid = (start + end)/2;
        if(arr[mid] == k){
            if((mid < arr.length - 1 && arr[mid+1] != k) || mid == arr.length - 1)
                return mid;
            else
                start = mid + 1;

        }else if(arr[mid] > k)
            end = mid - 1;
        else
            start = mid + 1;

        return getLastRecur(arr, k, start, end);
    }

    public static int getFirst(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return -1;

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right)/2;

        while(left < mid){
            if(arr[mid] == k){
                if(mid >= 1 && arr[mid - 1] != k || mid == 0)
                    return mid;
                else
                    right = mid - 1;
            }else if(arr[mid] > k)
                right = mid -1;
            else
                left = mid + 1;

            mid = (left + right)/2;
        }

        return arr[mid] == k ? mid : -1;
    }

    public static int getLast(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return -1;

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right)/2;

        while(left < mid){
            if(arr[mid] == k){
                if(mid < arr.length - 1 && arr[mid + 1] != k || mid == arr.length - 1)
                    return mid;
                else
                    left = mid + 1;
            }else if(arr[mid] > k)
                right = mid -1;
            else
                left = mid + 1;

            mid = (left + right)/2;
        }

        if(arr.length == 1)
            return arr[0] == k ? 0 : -1;

        if(mid == arr.length - 1)
            return mid;

        return  arr[mid+1] == k ? mid+1 : mid;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,3,3,3,4,5};
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            //System.out.println(GetNumberOfK(arr,3));
            GetNumberOfK(arr,3);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            //System.out.println(GetNumberOfK(arr,3));
            GetNumberOfK2(arr,3);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
