package Fun;

/**
 * Created by Administrator on 2017/8/25 0025.
 */
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int getKth(int[] arr, int k){
        if(arr == null || arr.length < k){
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0; i < k; i++){
            pq.offer(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        int k = sc.nextInt();
        System.out.println(getKth(arr, k));
    }

}
