package BSTtoList;

import TreeNode.TreeNode;

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
    }
}
