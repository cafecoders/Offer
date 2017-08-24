package PDD._1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class Main4 {
    static class Node{
        private int x;
        private int y;
        private int keys;
        private int step;

        public Node(int x, int y, int keys, int step){
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.step = step;
        }
    }

    public static void main(String[] args){
        /*char[][] map = {{'0','2','1','1','1'},
                        {'0','1','a','0','A'},
                        {'0','1','0','0','3'},
                        {'0','1','0','0','1'},
                        {'0','1','1','1','1'}};*/
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

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(map[i][j] == '2'){
                    System.out.println(bfs(map, rows, cols, i, j));
                    break;
                }
            }
        }
    }

    public static int bfs(char[][] map, int rows, int cols, int row, int col){
        Queue<Node> queue = new LinkedList<>();
        int[][][] mp = new int[101][101][1 << 10 + 1];
        int[][] next = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        queue.offer(new Node(row, col, 0, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = node.x + next[i][0];
                int y = node.y + next[i][1];
                int keys = node.keys;
                if(x < 0 || x >= rows || y < 0 || y >= cols || map[x][y] == '0'){
                    continue;
                }
                if(map[x][y] == '3'){
                    return node.step + 1;
                }
                if(map[x][y] >= 'a' && map[x][y] <= 'z'){
                    keys = keys | 1 << (map[x][y] - 'a');
                }
                if(map[x][y] >= 'A' && map[x][y] <= 'Z' && (keys >> (map[x][y] - 'A')) == 0){
                    continue;
                }
                if (mp[x][y][keys] == 0) {
                    mp[x][y][keys] = 1;
                    queue.offer(new Node(x, y, keys, node.step + 1));
                }
            }
        }
        return -1;
    }

}
