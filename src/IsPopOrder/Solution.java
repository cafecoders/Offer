package IsPopOrder;

import java.util.Stack;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(popA == null || popA.length == 0 || pushA == null || pushA.length == 0){
            return false;
        }
        Stack<Integer> s = new Stack<Integer>();
        int index1 = 0;
        int index2 = 0;
        s.push(pushA[index1]);
        while(!s.isEmpty()){
            if(s.peek() != popA[index2]){
                if(index1 == pushA.length-1){
                    return false;
                }
                s.push(pushA[++index1]);
            }else{
                s.pop();
                index2++;
            }

        }

        return true;

    }

    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,3,5,1,2};
        System.out.println(IsPopOrder(arr1, arr2));
    }
}
