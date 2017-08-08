package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _6FloatToInt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            float num = sc.nextFloat();
            System.out.println((int)(num + 0.5));
        }
    }
}
