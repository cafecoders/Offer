package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class _22GetHuiwenLength {
    public static int getLength(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        char[] chas = str.toCharArray();
        for(char c : chas){
            sb.append(c);
            sb.append("#");
        }
        chas = sb.toString().toCharArray();
        int[] pArr = new int[chas.length];
        int pR = -1;
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < chas.length; i++){
            pArr[i] = i < pR ? Math.min(pArr[2 * index -i], pR - i) : 1;
            while(pArr[i] + i < chas.length && i - pArr[i] > -1){
                if( chas[i + pArr[i]] == chas[i - pArr[i]] ){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }

        return max - 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            System.out.println(getLength(str));
        }
    }

}
