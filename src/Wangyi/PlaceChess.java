package Wangyi;

import java.util.*;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class PlaceChess {
    public static void placeChess(int[] x, int[] y){
        ArrayList<Integer> list = new ArrayList<>();
        Integer min, sum;
        int n = x.length;
        for(int i = 1; i <= n; i++){ //第i个格子上有i个棋子
            min = Integer.MAX_VALUE;
            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    sum = 0;
                    PriorityQueue<Integer> pq = new PriorityQueue<>(i, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });
                    for(int c = 0; c < n; c++){
                        int distance = Math.abs(x[c] - x[row]) + Math.abs(y[c] - y[col]);
                        sum += distance;
                        pq.add(distance);
                        if(pq.size() > i){
                            sum -= pq.poll();
                        }
                    }
                    min = Math.min(min, sum);
                }
            }
            list.add(min);
        }
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }

    public static void findStep(int[] xx, int[] yy){
        int n = xx.length;
        int min = Integer.MAX_VALUE, sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n && k != j; k++){
                    int Djk = Math.abs(xx[j] - xx[k]) + Math.abs(yy[j] - yy[k]);
                    pq.add(Djk);
                }
                int count = i;
                while(count-- > 0){
                    sum += pq.poll();
                }
                min = Math.min(sum, min);
            }
            list.add(min);
        }

        for(Integer i : list){
            System.out.print(i + " ");
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] x = new int[len];
        int [] y = new int[len];
        for(int i = 0; i < len; i++){
            x[i] = sc.nextInt();
        }
        for(int j = 0; j < len; j++){
            y[j] = sc.nextInt();
        }
        placeChess(x, y);
        //findStep(x, y);
    }
}
