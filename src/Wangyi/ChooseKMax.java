package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class ChooseKMax {
    public static long getMaxMulti(int[] nums, int k, int d) {
        if (nums == null || nums.length == 0 || nums.length < k || d < 0) {
            return 0;
        }
        int n = nums.length;

        long[][] max = new long[k][n];
        long[][] min = new long[k][n];

        for (int j = 0; j < n; j++) {
            min[0][j] = nums[j];
            max[0][j] = nums[j];
        }


        for (int i = 1; i < k; i++)
            for (int j = 0; j < n; j++)
                for (int m = 1; m <= d; m++) {
                    if (j - m >= 0) {
                        if (nums[j] > 0) {
                            min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * nums[j]);
                            max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * nums[j]);
                        } else {
                            min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * nums[j]);
                            max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * nums[j]);
                        }
                    }
                }
        long Max = 0;
        for (int i = 0; i < n; i++)
            Max = Math.max(Max, max[k - 1][i]);


        return Max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(getMaxMulti(arr, k, d));
    }
}
