package ZUOs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class MaxWindow {
    public static int[] getMaxWin(int[] arr, int width){
        if(arr == null || arr.length == 0 || width < 1){
            return null;
        }
        int[] res = new int[arr.length - width + 1];
        Deque<Integer> q = new LinkedList<>();
        int index = 0;

        int r = 0;
        for(;r < arr.length; r++){
            while(!q.isEmpty() && arr[q.peekLast()] <= arr[r]){
                q.pollLast();
            }
            q.offer(r);
            if(r - width == q.peekFirst()){
                q.pollFirst();
            }
            if(r >= width - 1){
                res[index++] = arr[q.peekFirst()];
            }

        }

        return res;
    }

    public static void main(String [] args){
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int width = 3;

        int[] a = getMaxWin(arr, width);
        for (Integer i : a) {
            System.out.print(i + " ");
        }

    }



}
