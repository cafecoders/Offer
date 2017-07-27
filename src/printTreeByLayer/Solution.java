package printTreeByLayer;
import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return list;
        }
        TreeNode last = root;
        TreeNode nextLast = root.right == null ? root.left : root.right;
        q.offer(root);

        while(root != null){
            list.add(q.poll().val);
            if(root.left != null){
                q.offer(root.left);

            }
            if(root.right != null){
                q.offer(root.right);

            }

            root = q.peek();

        }

        return list;
    }

    public static void main(String[] args){
        TreeNode head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);

        ArrayList<Integer> list = new ArrayList<>();
        list = PrintFromTopToBottom(head);
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }
}
