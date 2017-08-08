package HUAWEI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class _19MazeProblem {
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean hasPathCore(int[][] map, int rows, int cols, int row, int col,
                                      boolean[] visited, ArrayList<Point> list){
        if(row == rows - 1 && col == cols - 1){
            list.add(new Point(row, col));
            return true;
        }
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col]
                && map[row][col] == 0){
            visited[row * cols + col] = true;
            list.add(new Point(row, col));

            hasPath = hasPathCore(map, rows, cols, row+1, col, visited, list)
                    || hasPathCore(map, rows, cols, row, col+1, visited, list)
                    || hasPathCore(map, rows, cols, row, col-1, visited, list)
                    || hasPathCore(map, rows, cols, row-1, col, visited, list);

            if(!hasPath){
                visited[row * cols + col] = false;
                list.remove(list.size() - 1);
            }
        }

        return hasPath;
    }

    public static boolean hasPath(int[][] map, ArrayList<Point> list){
        if(map == null || map.length == 0 || map[0].length == 0){
            return false;
        }
        int rows = map.length;
        int cols = map[0].length;
        boolean[] visited = new boolean[rows*cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(hasPathCore(map, rows, cols, row, col, visited, list)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] map = new int[rows][cols];
            for (int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            ArrayList<Point> list = new ArrayList<>();
            hasPath(map, list);
            for(Point point : list){
                System.out.println("(" + point.x + "," + point.y + ")");
            }
        }
    }
}
