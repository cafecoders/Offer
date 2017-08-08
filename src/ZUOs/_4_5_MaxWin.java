package ZUOs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class _4_5_MaxWin {
    public static int[] getMaxWin(int[] arr, int width){
        if(arr == null || arr.length == 0){
            return null;
        }
        int[] res = new int[arr.length - width + 1];
        int index = 0;
        Deque<Integer> q = new LinkedList<>();
        for(int R = 0; R < arr.length; R++){
            while(!q.isEmpty() && arr[q.peekLast()] <= arr[R]){
                q.pollLast();
            }
            q.offer(R);
            if(R - width + 1 >= 0){
                res[index++] = arr[q.peekFirst()];
            }
            if(R - width + 1 == q.peekFirst()){
                q.pollFirst();
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWin(arr, 3);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}



