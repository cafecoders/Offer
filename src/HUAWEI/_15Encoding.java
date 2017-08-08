package HUAWEI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _15Encoding {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*while(sc.hasNext()){
            String str = sc.next();
            System.out.println(encode(str));
        }*/
        // this is for empty bottle problem.
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }
            list.add(num/2);
        }
        for(Integer i : list){
            System.out.println(i);
        }
    }

    public static String encode(String str){
        String dict1="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String dict2="bcdefghijklmnopqrstuvwxyza222333444555666777788899991234567890";
        char[] chas = str.toCharArray();
        char[] res = new char[chas.length];
        for(int i = 0; i < chas.length; i++){
            res[i] = dict2.charAt(dict1.indexOf(chas[i]));
        }
        return String.valueOf(res);
    }
}
