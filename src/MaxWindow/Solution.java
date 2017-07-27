package MaxWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class Solution {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length < size){
            return list;
        }
        Deque<Integer> q = new LinkedList<Integer>();
        int r = 0;
        while(r <= num.length - 1){
            while(!q.isEmpty() && num[r] >= num[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(r);
            if(r - size == q.peekFirst()){
                q.pollFirst();
            }

            if(r >= size - 1){
                list.add(num[q.peekFirst()]);
            }

            r++;
        }

        return list;
    }

    public static void main(String[] args){
        /*int[] arr = {1,8,5,1,6,6,9,1,4,9,9};
        ArrayList<Integer> list = maxInWindows(arr, 3);
        for(Integer i : list){
            System.out.print(i + " ");
        }*/

        /*String matrix = "abcesfcsadee";
        String strr = "bdee";
        System.out.println(hasPath(matrix.toCharArray(), 3, 4, strr.toCharArray()));*/

        //System.out.println(getDigitSum(233));
        System.out.println(movingCount(2, 4,4));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || matrix.length == 0){
            return false;
        }
        boolean[] isVisited = new boolean[rows*cols];
        int pathLength = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(process(matrix, row, rows, col, cols, str, pathLength, isVisited)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean process(char[] matrix, int row, int rows, int col, int cols,
                                  char[] str, int pathLength, boolean[] isVisited){
        if(pathLength == str.length){
            return true;
        }

        boolean hasPath = false;
        if(row >=0 && row < rows && col >=0 && col <= cols && matrix[row * cols + col] == str[pathLength]
                && !isVisited[row * cols +col]){
            ++pathLength;
            isVisited[row * cols + col] = true;

            hasPath = process(matrix, row-1, rows, col, cols, str, pathLength, isVisited)
                    || process(matrix, row+1, rows, col, cols, str, pathLength, isVisited)
                    || process(matrix, row, rows, col-1, cols, str, pathLength, isVisited)
                    || process(matrix, row, rows, col+1, cols, str, pathLength, isVisited);

            if(!hasPath){
                --pathLength;
                isVisited[row*cols + col] = false;
            }
        }
        return hasPath;
    }


    public boolean hasPath2(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
        return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }

    public static int movingCount(int threshold, int rows, int cols)
    {
        int[] isVisited = new int[rows * cols];
       // int count = 0;

        return process2(threshold, rows, cols, 0, 0, isVisited);
    }

    public static int process2(int threshold, int rows, int cols, int row, int col, int[] isVisited){
        int count = 0;
        if(check(threshold, rows, cols, row, col, isVisited)){
            isVisited[row * cols + col] = 1;
            count = 1 + process2(threshold, rows, cols, row-1, col, isVisited)
                    + process2(threshold, rows, cols, row+1, col, isVisited)
                    + process2(threshold, rows, cols, row, col-1, isVisited)
                    + process2(threshold, rows, cols, row, col+1, isVisited);
        }

        return count;
    }

    public static boolean check(int threshold, int rows, int cols, int row, int col, int[] isVisited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && isVisited[row * cols + col] == 0) {
            return true;
        }
        return false;
    }

    public static int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num = num/10;
        }

        return sum;
    }

}
