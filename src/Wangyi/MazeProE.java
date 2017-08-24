package Wangyi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class MazeProE {
    static class Node{
        int x;
        int y;
        int step;
        public Node(int x, int y, int step){
            this.step = step;
            this.x = x;
            this.y = y;
        }
    }

    public static int getPath(char[][] map, int row, int col, int[][] steps){
        if(map == null || map.length == 0){
            return 0;
        }
        int rows = map.length;
        int cols = map[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        Queue<Node> que = new LinkedList<>();
        Node node = new Node(row, col, 0);
        que.offer(node);
        while(!que.isEmpty()){
            node = que.poll();
            isVisited[node.x][node.y] = true;
            for(int i = 0; i < steps.length; i++){
                int x = node.x + steps[i][0];
                int y = node.y + steps[i][1];
                int step = node.step;
                if(x >= rows || x < 0 || y < 0 || y >= cols || map[x][y] == 'X' || isVisited[x][y]){
                    continue;
                }
                if(x == rows - 1 && y == cols - 1){
                    return step + 1;
                }
                que.offer(new Node(x, y, step + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        char[][] map = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            String str = sc.next();
            for(int j = 0; j < cols; j++){
                map[i][j] = str.charAt(j);
            }
        }
        int row = sc.nextInt();
        int col = sc.nextInt();
        int len = sc.nextInt();
        int[][] steps = new int[len][2];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                steps[i][j] = sc.nextInt();
            }
        }

        System.out.println(getPath(map, row, col, steps));
    }
}
