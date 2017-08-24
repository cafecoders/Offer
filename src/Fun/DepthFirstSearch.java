package Fun;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class DepthFirstSearch {
    private int[] arr = {1,2,3,4};
    private boolean[] isVisited = new boolean[arr.length];
    private int[][] graph = new int[arr.length][arr.length];
    private  HashSet<String> set = new HashSet<>();
    private String combine = "";

    public HashSet<String> getAllCombination(){
        bulidGraph();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            dfs(i);
        }
        return set;
    }

    public void bulidGraph(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i == j){
                    graph[i][j] = 0;
                }else{
                    graph[i][j] = 1;
                }
            }
        }
    }

    public void dfs(int node){
        isVisited[node] = true;
        combine += arr[node];
        if(combine.length() == arr.length){
            set.add(combine);
        }
        for(int i = 0; i < arr.length; i++){
            if(graph[node][i] == 1 && !isVisited[i]){
                dfs(i);
            }
        }
        isVisited[node] = false;
        combine = combine.substring(0, combine.length() - 1);
    }

    public static void main(String[] args){
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.getAllCombination();
        for(String str : depthFirstSearch.set){
            System.out.print(str + " ");
        }
    }
}
