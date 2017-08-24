package Wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class InaRest {
    public static class Guest{
        int b;
        int c;
        public Guest(int b, int c){
            this.b = b;
            this.c = c;
        }
    }
    public static int getMaxCost(int[] a, int[] b, int[] c){
        int lena = a.length;
        Arrays.sort(a);
        int lenb = b.length;
        ArrayList<Guest> list = new ArrayList<>();
        Guest[] guests = new Guest[lenb];
        for(int i = 0; i < lenb; i++){
            //list.add(new Guest(b[i], c[i]));
            guests[i] = new Guest(b[i], c[i]);
        }
        Arrays.sort(guests, new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if(o1.b > o2.b){
                    return 1;
                }if(o1.b < o2.b){
                    return -1;
                }else{
                    if(o1.c >= o2.c){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        int[] dp = new int[lena];
        int[] dp_old = new int[lena];
       /* for(int i = 0; i < lena; i++){
            if(a[i] >= guests[0].b){
                while(i < lena){
                    dp[i++][0] = guests[0].c;
                }
            }
        }*/
        dp[0] = a[0] >= guests[0].b ? guests[0].c : 0;
        dp_old[0] = dp[0];
        for(int j = 1; j < lena; j++){
            dp[j] = a[j] >= guests[0].b ? Math.max(dp[j-1], guests[0].c) : dp[j-1];
            dp_old[j] = dp[j];
        }
        for(int j = 1; j < lenb; j++){
            for(int i = 0; i < lena; i++){
                if(a[i] >= guests[j].b){
                    dp[i] = Math.max( (i - 1 >= 0 ? dp_old[i-1] : 0) + guests[j].c, dp_old[i]);
                }
            }
            for(int i = 0; i < lena; i++){
                dp_old[i] = dp[i];
            }
        }
        return dp[lena-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lena = sc.nextInt();
        int lenb = sc.nextInt();
        int[] a = new int[lena];
        int[] b = new int[lenb];
        int[] c = new int[lenb];
        for(int i =0; i < lena; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < lenb; i++){
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        System.out.println(getMaxCost(a, b, c));
    }
}
