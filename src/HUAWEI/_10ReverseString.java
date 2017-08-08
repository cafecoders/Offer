package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _10ReverseString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] chas = str.toCharArray();
            reverse(chas, 0, chas.length - 1);
            int start = 0, end = 0;
            for(int i = 0; i < chas.length; i++){
                if(chas[i] == ' '){
                    end = i-1;
                    reverse(chas, start, end);
                    start = i + 1;
                }
            }
            reverse(chas, start, chas.length - 1);
            System.out.println(String.valueOf(chas));
        }
    }

    public static void reverse(char[] chas, int start, int end){
        //int len = chas.length;
        for(int i = start, j = end; i < j; i++, j--){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }
    }
}
