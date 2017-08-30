package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            lists.add(new ArrayList<Integer>());
            return lists;
        }
        process(nums, 0, lists);
        return lists;
    }

    public void process(int[] nums, int start, List<List<Integer>> lists){
        ArrayList<Integer> list = new ArrayList<>();
        if(start ==  nums.length - 1){
            for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
            lists.add(list);
        }else{
            for(int i = start; i < nums.length; i++){
                swap(nums, start, i);
                process(nums, start+1, lists);
                swap(nums, start, i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
