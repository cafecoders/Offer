package ZUOs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
class Dot{
    int width;
    int length;
    public Dot(int width, int length){
        this.width = width;
        this.length = length;
    }
}
public class RussianKingProblem {
    public static class Dot{
        int width;
        int length;
        public Dot(int width, int length){
            this.width = width;
            this.length = length;
        }
    }

    public static class DotComparator implements Comparator<Dot>{

        @Override
        public int compare(Dot o1, Dot o2) {
            if(o1.width == o2.width){
                if(o1.length < o2.length){
                    return 1;
                }else if(o1.length > o2.length){
                    return -1;
                }else{
                    return 0;
                }
            }else if(o1.width > o2.width){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        int[][] arr = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        Dot[] dots = new Dot[arr.length];
        for(int i = 0; i < arr.length; i++){
                dots[i] = new Dot(arr[i][0], arr[i][1]);
            }

        Arrays.sort(dots, new DotComparator());
        int[] res = new int[arr.length];
        int i = 0;

        for(Dot dot : dots){
            System.out.println(dot.width + " " + dot.length);
            res[i++] = dot.length;
        }

        System.out.println(LIS2(res));
    }

    public static int LIS1(int[] res){
        int[] dp = new int[res.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < res.length; i++){
            dp[i] = 1;
             for(int j = 0; j < i; j++){
                 if(res[j] < res[i]){
                     dp[i] = Math.max(dp[i],dp[j] + 1);
                 }
             }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static int LIS2(int[] res){
        int[] dp = new int[res.length];
        int[] ends = new int[res.length];
        ends[0] = res[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for(int i = 0; i < res.length; i++){
            l = 0;
            r = right;
            while(l <= r){
                m = (l + r)/2;
                if(res[i] > ends[m]){
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = res[i];
            dp[i] = l + 1;
        }
        int count = 0;
        for(int i = 0; i < ends.length; i++){
            if(ends[i] == 0){
                break;
            }
            count++;
        }
        return count;

    }

    public static int find(int[] h, int val){
        int left = 0;
        int right = h.length - 1;
        int mid = (left + right)/2;
        while(left < right){
            if(h[mid] > val){
                right = mid - 1;
            }else if(h[mid] < val){
                left = mid + 1;
            }else {
                break;
            }
            mid = (left + right)/2;
        }
        return mid + 1;
    }



}
