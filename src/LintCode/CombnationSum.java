package LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by missinghigh on 2017/8/30.
 */
public class CombnationSum {
    public static List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<0 || k<0)
            return result;
        int start = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        DFS(n,k,start,result,list);
        return result;
    }

    public static void DFS(int n,int k,int start ,List<List<Integer>> result,ArrayList<Integer> list){
        if(list.size() == k){
            ArrayList<Integer> tmp = new ArrayList<Integer>(list);
            if(!result.contains(tmp)) // ¿É²»Òª
                result.add(tmp);
            return;
        }
        for(int i = start;i<=n ;i++){
            list.add(i);
            DFS(n,k,i+1,result,list);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args){
        //int[] arr = { 2, 4, 6, 7};
        int target = 3;
        List<List<Integer>> lists = combine(4, target);
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
