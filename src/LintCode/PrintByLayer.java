package LintCode;

import java.util.*;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class PrintByLayer {
    public static class TreeNode {
             public int val;
             public TreeNode left, right;
             public TreeNode(int val) {
                     this.val = val;
                     this.left = this.right = null;
                 }
         }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<Integer> s = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode last = root;
        TreeNode nextLast = null;
        boolean order = true;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            list.add(node.val);

            if(node.left != null){
                q.offer(node.left);
                nextLast = node.left;
            }
            if(node.right != null){
                q.offer(node.right);
                nextLast = node.right;
            }

            if(node == last){
                last = nextLast;
                if(order){
                    lists.add(new ArrayList<>(list));
                }else{
                    List<Integer> tmp = new ArrayList<>(list);
                    while(!tmp.isEmpty()){
                        s.push(tmp.remove(0));
                    }
                    while(!s.isEmpty()){
                        tmp.add(s.pop());
                    }
                    lists.add(tmp);
                }
                list.clear();
                order = !order;
            }
        }

        return lists;
    }


    public static void main(String[] args){
        TreeNode head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);

        List<List<Integer>> lists = levelOrder(head);
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
