package findContinousSequence;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int l = 1;
        int r = 2;
        int curSum = l;
        while(l <= sum/2 && l <= r){
            if(curSum < sum){
                curSum += r++;
            }else if(curSum > sum){
                curSum -= l++;
            }else{
                findOne(l, r);
                curSum -= l++;
            }
        }

        return lists;
    }

    public static void findOne(int small, int big){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = small; i < big; i++)
            list.add(i);

        lists.add(list);
    }



    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length == 0){
            return list;
        }
        int l = 0;
        int r = array.length - 1;
        while(l <= r){
            if(array[l] + array[r] == sum){
                list.add(array[l]);
                list.add(array[r]);
                return list;
            }else if(array[l] + array[r] > sum){
                r--;
            }else {
                l++;
            }
        }

        return list;
    }

    public static String ReverseSentence(String str) {
        if(str == null || str.length() ==0){
            return null;
        }
        char[] chas = str.toCharArray();
        reverse(chas, 0, chas.length - 1);
        int pre = 0;
        for(int i = 0; i < chas.length; i++){
            if(chas[i] == ' '){
                reverse(chas, pre, i-1);
                pre = i+1;
            }
        }

        reverse(chas, pre, chas.length - 1);

        return String.valueOf(chas);
    }

    public static void reverse(char[] chas, int start, int end){
        for(int i = start, j = end; i <= j; i++, j--){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }
    }

    public static void main(String[] args){
        int num1 = 15;
        int num2 = 17;
        System.out.println(Add(num1, num2));
    }

    public static boolean isC(int [] numbers) {
        Arrays.sort(numbers);
        int numOfZ = 0;
        int numOfS = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                numOfZ++;
            }
            if(i > 0 && numbers[i-1] != 0 && numbers[i] - numbers[i-1] > 1){
                numOfS += numbers[i] - numbers[i-1] - 1;
            }
            if(i > 0 && numbers[i] == numbers[i-1] && numbers[i] != 0){
                return false;
            }
        }

        return numOfZ >= numOfS ? true : false;
    }

    public static int  Add(int num1,int num2) {
        while(num2 != 0){
            int sum = num1^num2;
            int carry = (num1&num2)<<1;
            num2 = carry;
            num1 = sum;
        }

        return num1;
    }


}


