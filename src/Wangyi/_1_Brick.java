package Wangyi;

import java.util.*;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class _1_Brick {
    public static void getResult(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < arr.length ; i++){
            list.add(arr[i]);
            while(!list.isEmpty()){
                s.push(list.remove(0));
            }
            while(!s.isEmpty()){
                list.add(s.pop());
            }
        }
        int count = 0;
        for(Integer i : list){
            if(count++ != arr.length-1)
            System.out.print(i + " ");
            else
                System.out.print(i);
        }
    }

    public static long getDays(int x, int f, int d, int p){
        return Math.min((d + (long)(f * p))/(x + p),Math.min(d/x, (f + (d- x * f)/((p+x)))));
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        getResult(arr);*/
        //System.out.println(getResult(arr));
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(getDays(x, f, d, p));
    }
}
