package HUAWEI;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _8ReverseUnique {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] chas1 = str.toCharArray();
            reverse(chas1);
            HashSet<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < chas1.length; i++){
                if(!set.contains(chas1[i])){
                    set.add(chas1[i]);
                    sb.append(chas1[i]);
                }
            }
            System.out.println(sb);
        }
    }

    public static void reverse(char[] chas){
        int len = chas.length;
        for(int i = 0, j = len - 1; i < j; i++, j--){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }
    }
}
