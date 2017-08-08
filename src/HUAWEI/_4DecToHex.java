package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _4DecToHex {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String str = sc.next().substring(2);

            System.out.println(Integer.parseInt(str, 16));

        }

    }
}
