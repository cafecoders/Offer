package HUAWEI;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _9AsciiCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] chas1 = str.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for(Character c : chas1){
                if(c <= 127 && c >= 0){
                    set.add(c);
                }
            }
            System.out.println(set.size());

        }
    }

}
