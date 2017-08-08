package HUAWEI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class _20BroWords {
    public static void printBroWords(String[] dict, String str, int k){
        if(dict == null || dict.length < k){ //8 abbc bbca asdf aglgg aggk cbba bcbb acbb abbc 2
            System.out.println(0);
            return ;
        }
        Arrays.sort(dict);
        ArrayList<String> list = new ArrayList<>();
        for(String s : dict){
            if(isBro(s, str)){
                list.add(s);
            }
        }

        System.out.println(list.size());
        if(list.size() > 0)
            System.out.println(list.get(k-1));
    }

    public static boolean isBro(String s1, String s2){
        if(s1.length() != s2.length() || s1.equals(s2)){
            return false;
        }
        char[] chas1 = s1.toCharArray();
        char[] chas2 = s2.toCharArray();
        Arrays.sort(chas1);
        Arrays.sort(chas2);

        return String.valueOf(chas1).equals(String.valueOf(chas2));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            TreeSet<String> dict = new TreeSet<>();
            int num = sc.nextInt();
            String[] strs = new String[num];
            for(int i = 0; i < num; i++){
                //dict.add(sc.next());
                strs[i] = sc.next();
            }
            String str = sc.next();
            int k = sc.nextInt();
            printBroWords(strs, str,k);

        }
    }
}
