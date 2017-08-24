package Wangyi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class FrogMaze {
    public static class Node{
        int x;
        int y;
        int HP;
        public Node(int x, int y, int HP){
            this.x = x;
            this.y = y;
            this.HP = HP;
        }
    }

    public static boolean bfs(int[][] map, int row, int col, int HP){
        ArrayList<Node> list = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        Node node = new Node(row, col, HP);
        int rows = map.length;
        int cols = map[0].length;
        boolean [][] isVisited = new boolean[rows][cols];
        int[][] steps = {
                {0,1}, {1,0}, {0,-1}, {-1, 0}
        };
        que.offer(node);
        isVisited[node.x][node.y] = true;
        while(!que.isEmpty()){
            node = que.poll();

            for(int i = 0; i < steps.length; i++){
                int x = node.x + steps[i][0];
                int y = node.y + steps[i][1];
                int cost = ( (steps[i][0] == 0) ? -1 : ( (steps[i][0] == 1) ? 0 : -3) );
                int curHP = node.HP + cost;
                if(x == 0 && y == 3 && curHP >= 0){
                    return true;
                }
                if(curHP <= 0 || x >= rows || x < 0 || y < 0 || y >= cols || map[x][y] == 0){
                    curHP -= cost;
                    continue;
                }

                if(x == 0 && y == 3){
                    return true;
                }
                if(!isVisited[x][y]){
                    que.offer(new Node(x, y, curHP));
                }else{
                    curHP -= cost;
                }

            }
        }

        return false;
    }

    public static boolean dfs(int[][] map, int row, int col, int HP, boolean[][] isVisited, ArrayList<Node> list){
        int rows = map.length;
        int cols = map[0].length;

        boolean getPath = false;

        if(row == 0 && col == cols - 1 && HP >= 0){
            list.add(new Node(row, col, HP));
            return true;
        }

        if(row < rows && row >= 0 && col < cols && col >= 0 && map[row][col] == 1 && HP > 0 && !isVisited[row][col]){
            isVisited[row][col] = true;
            list.add(new Node(row, col, HP));
            getPath = dfs(map, row, col+1, HP-1, isVisited, list)
                    || dfs(map, row+1, col, HP, isVisited, list)
                    || dfs(map, row, col-1, HP-1, isVisited, list)
                    || dfs(map, row-1, col, HP-3, isVisited, list);

            if(!getPath){
                isVisited[row][col] = false;
                list.remove(list.size() - 1);
            }
        }

        return getPath;
    }

    public static void main(String[] args){
        int[][] map = {
                {1,0,0,1}, {1,1,0,1},{0,1,1,1}, {0, 0, 1, 1}
        };
        int HP = 10;
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        ArrayList<Node> list = new ArrayList<>();
        System.out.println(bfs(map, 0, 0, HP));
        System.out.println(dfs(map, 0, 0, HP, isVisited, list));
        for(Node node : list){
            System.out.println(node.x + " " + node.y + " " + node.HP);
        }
    }
}
