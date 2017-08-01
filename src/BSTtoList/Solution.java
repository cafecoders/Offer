package BSTtoList;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    private TreeNode leftLast = null;
    public TreeNode Convert(TreeNode head) {
        if(head == null){
            return null;
        }
        if(head.left == null && head.right == null){
            leftLast = head;
            return head;
        }
        TreeNode left = Convert(head.left);
        if(left != null){
            head.left = leftLast;
            leftLast.right = head;
        }
        leftLast = head;

        TreeNode right = Convert(head.right);
        if(right != null){
            head.right = right;
            right.left = head;
        }
        return left != null ? left : head;

        //HashMap<Integer, Integer>
        //Hashtable<Integer, Integer>
        //HashSet<Integer>
        //ConcurrentHashMap<Integer, Integer>
        //ArrayList<Integer>
        //String str = "";
        //str.contains()
    }
}
