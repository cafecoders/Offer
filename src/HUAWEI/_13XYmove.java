package HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _13XYmove {
    public static String getPosition(String str){
        if(str == null){
            return "0,0";
        }
        int x = 0, y = 0;
        int distance = 0;
        String[] strs = str.split(";");
        for(int i = 0; i < strs.length; i++){
            char[] chas = strs[i].toCharArray();
            if(chas.length > 3 && chas.length < 2){
                continue;
            }
            if( (chas.length == 3 && chas[2] <= '9' && chas[2] >= '0' && chas[1] <= '9' && chas[1] >= '0')
                    || (chas.length == 2 && chas[1] <= '9' && chas[1] >= '0')){
                distance = Integer.parseInt(strs[i].substring(1));
            }
            if(chas[0] == 'A'){
                x -= distance;
            }else if(chas[0] == 'D'){
                x += distance;
            }else if(chas[0] == 'W'){
                y += distance;
            }else if(chas[0] == 'S'){
                y -= distance;
            }
                distance = 0;

        }

        return String.format("%s,%s", x, y);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(getPosition(str));
        }
    }
}
