package HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _11SortString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           int num = sc.nextInt();
            String[] strs = new String[num];
            for(int i = 0; i < num; i++){
                strs[i] = sc.next();
            }
            Arrays.sort(strs);
            for(String str : strs){
                System.out.println(str);
            }
        }
    }
}
