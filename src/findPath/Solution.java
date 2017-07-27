package findPath;
import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    static  ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
      if(root == null){
          return lists;
      }
        target -= root.val;
        list.add(root.val);
        if(target == 0 && root.left == null && root.right == null){
            lists.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);

        list.remove(list.size() - 1);
        return lists;
    }

    public static void main(String[] args){
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(8);
        head.left.left = new TreeNode(3);
        head.right = new TreeNode(12);
        head.left.right = new TreeNode(4);

        FindPath(head, 22);

        for(ArrayList<Integer> list : lists){
            for(Integer i: list) {
                System.out.print(i + " ");

            }
            System.out.println();
        }

    }
}
