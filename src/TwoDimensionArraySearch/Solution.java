package TwoDimensionArraySearch;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class Solution {
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }

        int row = 0;
        int col = array[0].length-1;

        while(row < array.length && col > -1){
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                row++;
            }else{
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        System.out.print(Find(0, array));
    }
}