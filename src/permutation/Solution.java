package permutation;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        String str = "aba";
        ArrayList<String> list = permutation(str);
        for(String i: list)
            System.out.print(i + " ");
    }

    public static ArrayList<String> permutation(String str){
        ArrayList<String> re = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return re;

        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }

    public static void fun(HashSet<String> re, char[] chas, int k){
        if(k == chas.length){
            re.add(new String(chas));
            return;
        }

        for(int i = k; i < chas.length; i++){
            swap(chas, i, k);
            fun(re, chas, k+1);
            swap(chas, i, k);
        }
    }

    public static void swap(char[] chas, int i, int j){
        if(i != j){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }
    }



}
