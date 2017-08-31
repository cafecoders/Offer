package LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by missinghigh on 2017/8/30.
 */
public class CombnationSum_I {
    public static List<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        DFS(lists, list, candidates, target, start);
        return lists;
    }

    public static void DFS(List<ArrayList<Integer>> lists, ArrayList<Integer> list, int[] cand, int target, int start){
        if(target == 0){
            ArrayList<Integer> tmp = new ArrayList<>(list);
            if(!lists.contains(list)){
                lists.add(tmp);
            }
            return;
        }
        for(int i = start; i < cand.length; i++){
            if(target < cand[i]){
                return;
            }
            target -= cand[i];
            list.add(cand[i]);
            DFS(lists, list, cand, target, i);
            target += cand[i];
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] arr = { 2, 4, 6, 7};
        int target = 6;
        List<ArrayList<Integer>> lists = combinationSum(arr, target);
        for(ArrayList<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
