package PDD._1;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        int len1 = str1.length();
        int len2 = str2.length();
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        reverse(chas1, len1);
        reverse(chas2, len2);
        if(str1.equals("0") || str2.equals("0")){
            System.out.print("0");
        }else{
            System.out.println(getMulti(chas1, chas2));
            System.out.println(getResult(str1.toCharArray(), str2.toCharArray()));
        }
        in.close();
    }

    public static String getResult(char[] chas1, char[] chas2){
        if(chas1 == null || chas1.length == 0 || chas2 == null || chas2.length == 0){
            return "";
        }
        reverse(chas1);
        reverse(chas2);
        int[] val = new int[chas1.length + chas2.length];
        int[] carry = new int[chas1.length + chas2.length];
        for(int i = 0; i < chas1.length; i++){
            for(int j = 0; j < chas2.length; j++){
                val[i + j] += (chas1[i] - '0') * (chas2[j] - '0');
            }
        }

        for(int k = 0; k < chas1.length + chas2.length - 1; k++){
            int tmp = val[k] + (k > 0 ? carry[k-1] : 0);
            val[k] = tmp % 10;
            carry[k] = tmp / 10;
        }

        StringBuilder sb = new StringBuilder();
        if(carry[chas1.length + chas2.length -2] != 0){
            sb.append(carry[chas1.length + chas2.length -2]);
        }
        for(int i = chas1.length + chas2.length - 2; i >= 0; i--){
            sb.append(val[i]);
        }
        return sb.toString();
    }

    public static void reverse(char[] chas){
        int len = chas.length;
        for(int i = 0, j = len - 1; i < j; i++, j--){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }
    }
    public static void reverse(char[] chas, int len){
        for(int i = 0; i < len/2; i++){
            chas[i] += chas[len - 1 -i];
            chas[len - 1 -i] = (char)(chas[i] - chas[len - 1 -i]);
            chas[i] = (char)(chas[i] - chas[len - 1 -i]);
        }
    }

    public static String  getMulti(char[] chas1, char[] chas2){
        int len1 = chas1.length;
        int len2 = chas2.length;

        int len = len1 + len2 + 3;
        int[] multi = new int[len];

        for(int j = 0; j < len2; j++){
            for(int i = 0; i < len1; i++){
                multi[i+j] = Integer.parseInt(String.valueOf(chas1[i])) * Integer.parseInt(String.valueOf(chas2[j]));
            }
        }

        int m = 0;

        for(m = 0; m < len; m++){
            int c = multi[m] / 10;
            multi[m] = multi[m]%10;
            if(c > 0){
                multi[m+1] += c;
            }
        }

        for(m = len - 1;m >=0; m--){
            if(multi[m] > 0){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i <= m; i++){
            sb.append(multi[m - i]);
        }
        return sb.toString();
    }
}
