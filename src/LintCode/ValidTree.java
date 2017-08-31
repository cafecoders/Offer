package LintCode;

import java.util.*;

/**
 * Created by missinghigh on 2017/8/31.
 */
public class ValidTree {
    public static boolean validTree1(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();//graph�м��Ǿ���ڵ�ֵ��ֵ�ǰ��������е����ڽڵ��set
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < 2; j++){
                Set<Integer> pairs = graph.get(edges[i][j]);//��ÿ�������㣬ȡ����set
                if(pairs == null){
                    pairs = new HashSet<>();
                    graph.put(edges[i][j], pairs);
                }
                pairs.add(edges[i][1-j]);//��һ�Ա��ϵ���һ�������map��
            }
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        //ѡȡһ���㿪ʼ������ 0
        visited.add(0);
        current.add(0);
        while(!current.isEmpty()){
            Set<Integer> next = new HashSet<>();
            for(Integer node : current){
                Set<Integer> pairs = graph.get(node);// ȡ��set�еĽ����ٽ��set
                if(pairs == null) continue;
                for(Integer someNei : pairs){
                    if(visited.contains(someNei))//����ĳһ�ھӱ����ʹ������ʾ�γɻ�
                        return false;
                    next.add(someNei);
                    visited.add(someNei);
                    graph.get(someNei).remove(node);
                }
            }
            current = next;
        }

        return visited.size() == n;
    }

    public static boolean validTree2(int n , int[][] edges){
        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        if(hasCycle(-1, 0, visited, adjList)){
            return false;
        }
        if(visited.size() != n){
            return false;
        }

        return true;
    }

    public static boolean hasCycle(int pred, int vertex, HashSet<Integer> visited, List<List<Integer>> adjList){
        visited.add(vertex);
        for(int next : adjList.get(vertex)){
            if(next != pred){
                if(visited.contains(next)){
                    return true;
                }else{
                    if(hasCycle(vertex, next, visited, adjList)){
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public static void main(String[] args){
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(validTree1(n, edges));
        System.out.println(validTree2(n, edges));
    }
}
