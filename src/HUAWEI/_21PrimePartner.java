package HUAWEI;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class _21PrimePartner {
    static int[] nums ;

    static int n ;

    static boolean[][] graph;

    static boolean[] used;

    static int[] girl;

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i ++) {
                nums[i] = cin.nextInt();
            }

            graph = new boolean[n][n];

            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (i == j) {
                        graph[i][j] = false;
                    } else {
                        graph[i][j] = isPrime(nums[i] + nums[j]);
                    }
                }
            }

            girl = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                used = new boolean[n];
                if (find(i)) {
                    sum += 1;
                }
            }
            System.out.println(sum / 2);
        }
    }

    static boolean find(int x) {
        for (int i = 0; i < n; i ++) {
            if (graph[x][i] && used[i] == false) {
                used[i] = true;
                if (girl[i] == 0 || find(girl[i])) {
                    girl[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i ++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
