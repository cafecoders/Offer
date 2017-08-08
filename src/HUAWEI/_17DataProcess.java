package HUAWEI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _17DataProcess {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int leni = sc.nextInt();
            String[] I = new String[leni];
            for(int i = 0; i < leni; i++){
                I[i] = String.valueOf(sc.nextInt());
            }
            int lenr = sc.nextInt();
            int[] R = new int[lenr];
            for(int i = 0; i < lenr; i++){
                R[i] = sc.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            Arrays.sort(R);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(R[0]);
            for(int i = 1; i < R.length; i++){
                if(R[i] != R[i-1]){
                    list.add(R[i]);
                }
            }



        }
    }
}
