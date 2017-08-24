package Wangyi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class ArrayLike {
    static int mod = 1000000007;
    public static int getNum(int n, int k){
        int[][] dp = new int[n][k+1];
        for(int i = 1; i <= k; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < n; i++){
            int sum = 0;
            for(int j = 1; j <= k; j++){
                sum = (sum + dp[i-1][j]) % mod;
            }
            for(int j = 1; j <= k; j++){
                int invalid = 0;
                int p = 2;
                while(p*j <= k){
                    invalid = (invalid + dp[i-1][p*j]) % mod;
                    p++;
                }
                dp[i][j] = (sum - invalid) % mod;
            }
        }
        int count = 0;
        for(int j = 1; j <= k; j++){
            count = (count + dp[n-1][j]) % mod;
        }
        return count;
    }

    public static void main(String [] args){
        /*Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getNum(n, k));*/
       // System.out.println(Long.MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int [] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = new Random().nextInt(20);
            pq.add(arr[i]);
        }
        for(int i = 0; i < 10; i++){
            System.out.print(pq.poll() + " ");
        }
    }
}
