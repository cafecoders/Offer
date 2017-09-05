package LintCode;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class SurroundRegion {
    public static void surroundedRegions(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if((board[row][col] == 'O' ) && (col == 0 || col == cols - 1
                        || row  == 0 || row == rows - 1 ))
                    DFS(board, rows, cols, row, col, isVisited);
            }
        }

       /* for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(board[row][col] != '#'){
                    board[row][col] = 'X';
                }else{
                    board[row][col] = 'O';
                }
            }
        }*/
    }

    public static void DFS(char[][] board, int rows, int cols, int row, int col, boolean[][] isVisited){
        if(row < 0 || row > rows-1 || col < 0 || col > cols-1 || isVisited[row][col] || board[row][col] == 'X'){
            return;
        }
        board[row][col] = '#';
        isVisited[row][col] = true;
        DFS(board, rows, cols, row+1, col, isVisited);
        DFS(board, rows, cols, row-1, col, isVisited);
        DFS(board, rows, cols, row, col+1, isVisited);
        DFS(board, rows, cols, row, col-1, isVisited);

    }

    public static void main(String[] args){
        //char[][] board = {{'x','x','x','x'},{'x', 'o','o','x'},{'x','x','o','x'},{'x','o','x','x'}};
        String[] strs = {"XOXX","OXOX","XOXO","OXOX","XOXO","OXOX"};
        char[][] board = new char[strs.length][4];
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                board[i][j] = strs[i].charAt(j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("======================");
        surroundedRegions(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
