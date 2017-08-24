package Wangyi;

import java.util.*;

/**
 * Created by Administrator on 2017/8/20 0020.
 */
public class MinK {
    public static void minK(ArrayList<Integer> list, int k){
        Stack<Integer> s = new Stack<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < list.size(); i++){
            if(i < k){
                pq.offer(list.get(i));
            }else{
                if(list.get(i) < pq.peek()){
                    pq.poll();
                    pq.offer(list.get(i));
                }
            }
        }
        while(!pq.isEmpty()){
            s.add(pq.poll());
        }
        while(s.size() != 1){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        int k = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        minK(list, k);
    }
}
