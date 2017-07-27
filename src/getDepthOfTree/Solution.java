package getDepthOfTree;
import TreeNode.TreeNode;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    public static int getDepth(TreeNode root, int level, boolean[] res){
        if(root == null){
            return level;
        }
        int lH = getDepth(root.left, level + 1, res);
        if(!res[0]){
            return level;
        }
        int rH = getDepth(root.right, level + 1, res);
        if(!res[0]){
            return level;
        }

        if(Math.abs(lH - rH) > 1){
            res[0] = false;
        }

        return Math.max(lH, rH);


    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        int level = 0;
        boolean[] res = new boolean[1];
        res[0] = true;
        getDepth(root, level, res);
        return res[0];
    }



    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res = array[0];
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 1; i < array.length; i++){
            res ^= array[i];
        }
        int index = findFirstBit1(res);
        for(int i = 0; i < array.length; i++){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    public static int findFirstBit1(int res){
        int index = 0;
        if((res & 0x1) == 1){
            return index;
        }else {
            res >>= 1;
            index++;
        }
        return index;
    }

    public static boolean isBit1(int num, int index){
        return (num>>index & 0x1) == 0 ? false : true;
    }


    public static void main(String[] ags){
        int[] arr = {1,1,2,2,3,4};
        /*TreeNode head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);
        head.right.right.right = new TreeNode(666);
        head.right.right.right.right = new TreeNode(666);

        TreeNode head2 = new TreeNode(100);
        head2.left = new TreeNode(21);
        head2.left.left = new TreeNode(37);
        head2.right = new TreeNode(-42);


        // System.out.println(getDepth(head));

        System.out.println(IsBalanced_Solution(head));
        System.out.println(5^5);*/
    }

}
