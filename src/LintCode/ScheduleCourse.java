package LintCode;

import java.util.*;

/**
 * Created by missinghigh on 2017/8/31.
 */
public class ScheduleCourse {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> posts = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            posts.add(new HashSet<Integer>());
        }
        // ½¨ÁÚ½Ó±í
        int[] preNums = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            //preNums[prerequisites[i][0]]++;
        }


        for(int i = 0; i < numCourses; i++){
            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                preNums[it.next()]++;
            }
        }

        for(int i = 0; i < numCourses; i++){
            int j = 0;
            for(; j < numCourses; j++){
                if(preNums[j] == 0){
                    break;
                }
            }
            if(j == numCourses){
                return false;
            }

            preNums[j] = -1;
            Set set = posts.get(j);
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                preNums[it.next()]--;
            }
        }

        return true;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites, List<Integer> reslist) {
        List<List<Integer>> posts = new LinkedList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            posts.add(new ArrayList<>());
        }

        int[] preNums = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNums[prerequisites[i][0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < preNums.length; i++){
            if(preNums[i] == 0){
                que.offer(i);
            }
        }

        int count = numCourses;
        while(!que.isEmpty()){
            int cur = que.poll();
            reslist.add(cur);
            count--;
            for(int i : posts.get(cur)){
                if(--preNums[i] == 0){
                    que.offer(i);
                }
            }
        }

        return count == 0;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        List<List<Integer>> posts = new LinkedList<List<Integer>>();
        List<Integer> reslist = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new ArrayList<>());
        }

        int[] preNums = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNums[prerequisites[i][0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < preNums.length; i++) {
            if (preNums[i] == 0) {
                que.offer(i);
            }
        }

        int count = numCourses;
        while (!que.isEmpty()) {
            int cur = que.poll();
            reslist.add(cur);
            count--;
            for (int i : posts.get(cur)) {
                if (--preNums[i] == 0) {
                    que.offer(i);
                }
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        for (int i : reslist) {
            res[index++] = i;
        }

        return res;
    }

    public static void main(String[] args){
        int n = 10;
        int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        List<Integer> resList = new ArrayList<>();
        System.out.println(canFinish2(n, prerequisites, resList));
        System.out.println(resList);
        int[] res = findOrder(n, prerequisites);
        for(int i : res){
            System.out.print(i + " ");
        }

    }
}
