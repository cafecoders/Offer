package PrintMatrixByLayer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int tr = 0;
        int dr = matrix.length-1;
        int tc = matrix[0].length-1;
        int dc = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(tr <= dr && dc <= tc){
            printByLayer(matrix, tr, dr, tc, dc, list);
            tr++;
            dr--;
            tc--;
            dc++;
        }

        return list;

    }

    public static void printByLayer(int[][] m, int tr, int dr, int tc, int dc, ArrayList<Integer> list){
        if(dr == tr){
            for(int i = dc; i <=tc; i++){
                list.add(m[tr][i]);
            }
            return ;
        }
        if(dc == tc){
            for(int i = tr; i <= dr; i++){
                list.add(m[i][dc]);
            }
            return ;
        }
        for(int i = dc; i <=tc; i++){
            list.add(m[tr][i]);
        }
        for(int i = tr+1; i <= dr; i++){
            list.add(m[i][tc]);
        }
        for(int i = tc-1; i >= dc; i--){
            list.add(m[dr][i]);
        }
        for(int i = dr-1; i >= tr+1; i--){
            list.add(m[i][dc]);
        }
    }

    public static void main(String[] args){
        int[][] m = {{1,2,3,4,5}
                };

        ArrayList<Integer> list = printMatrix(m);
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }
}
