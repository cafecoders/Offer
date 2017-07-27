package ReconstructBT;
import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }
        int start = 0;
        int end = pre.length - 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        Stack<Integer> s = new Stack<>();

        return process(pre, in, start, end, start, end, map);
    }

    public static TreeNode process(int[] pre, int[] in, int ps, int pe, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe)
            return null;

        TreeNode head = new TreeNode(pre[ps]);
        int index = map.get(pre[ps]);
        head.left = process(pre, in, ps + 1, ps + index - is, is, index - 1, map);
        head.right = process(pre, in, pe - ie + index + 1, pe, index + 1, ie, map);

        return head;
    }
}


   /* public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in  == null)
            return null;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    public TreeNode preIn(int[] pre, int pi, int pj, int[] in, int ni, int nj,
                          HashMap<Integer, Integer> map){
        if(pi > pj)
            return null;
        TreeNode root = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        root.left = preIn(pre, pi+1, pi+index-ni, in, ni, index-1, map);
        root.right = preIn(pre, pj-nj+index+1, pj, in, index+1, nj, map);
        return root;
    }*/