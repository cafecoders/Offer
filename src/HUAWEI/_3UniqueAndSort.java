package HUAWEI;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by missinghigh on 2017/8/1.
 */
public class _3UniqueAndSort {
    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i = 0; i < num; i++){
            set.add(sc.nextInt());
        }
        for(Integer i : set){
            System.out.println(i);
        }

    }
}
