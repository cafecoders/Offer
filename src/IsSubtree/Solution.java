package IsSubtree;
import TreeNode.TreeNode;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static int HasSubtree2(TreeNode root1,TreeNode root2) {
        String str1 = serialBT(root1);
        String str2 = serialBT(root2);
        int index = 0;

        index = getIndexOf(str1, str2);
        return index ;

    }
    public static boolean hasSubT(TreeNode node1, TreeNode node2){
        boolean res = false;

        if(node1 != null && node2 != null){
            if(node1.val == node2.val){
                res = doesTree1HasTree2(node1, node2);
            }
            if(!res)
                hasSubT(node1.left, node2);
            if(!res)
                hasSubT(node1.right, node2);

        }

        return res;
    }

    public boolean HasSubtree33(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = DoesTree1HaveTree233(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;

        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                res = does1has2(root1, root2);
            }
            if(!res){
                HasSubtree(root1.left, root2);
            }
            if(!res){
                HasSubtree(root1.right, root2);
            }
        }

        return res;
    }

    public static boolean does1has2(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }

        return does1has2(root1.left, root2.left) && does1has2(root1.right, root2.right);
    }

    public static String serialBT(TreeNode root){
        if(root == null){
            return "#!";
        }
        String str = "";
        str += root.val + "!";
        str += serialBT(root.left);
        str += serialBT(root.right);

        return str;
    }

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }


    public static boolean doesTree1HasTree2(TreeNode node1, TreeNode node2){
        if(node2 == null){
            return true;
        }
        if(node1 == null)
            return false;

        if(node1.val != node2.val){
            return false;
        }

        return doesTree1HasTree2(node1.left, node2.left) && doesTree1HasTree2(node1.right, node2.right);
    }


    public static void main(String[] ags){
        TreeNode head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);

        TreeNode head2 = new TreeNode(100);
        head2.left = new TreeNode(21);
        head2.left.left = new TreeNode(37);
        head2.right = new TreeNode(-42);


        System.out.println(HasSubtree(head, head2));
    }









        public boolean DoesTree1HaveTree233(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 != null) return false;
           if (root2 == null) return true;
            if (root1.val != root2.val) return false;

            return DoesTree1HaveTree233(root1.left, root2.left) && DoesTree1HaveTree233(root1.right, root2.right);
            }
    }

