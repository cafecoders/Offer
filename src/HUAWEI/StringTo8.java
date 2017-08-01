package HUAWEI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class StringTo8 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.length() % 8 != 0) {
                str = str + "00000000";

                while (str.length() >= 8) {
                    System.out.println(str.substring(0, 8));
                    list.add(str.substring(0, 8));
                    str = str.substring(8);
                }
            }
        }

        for(String str : list){
            System.out.println(str);
        }


      /*  Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = new String(sc.nextLine());
            if(s.length()%8 !=0 )
                s = s + "00000000";

            while(s.length()>=8){
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }*/
    }
}
