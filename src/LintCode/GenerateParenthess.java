package LintCode;

import java.util.ArrayList;

/**
 * Created by missinghigh on 2017/8/30.
 */
public class GenerateParenthess {
    public static ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int leftCount = 0, rightCount = 0;
        DFS(list, sb, leftCount, rightCount, n);
        return list;
    }

    public static void DFS(ArrayList<String> list, StringBuilder sb, int leftCount, int rightCount, int n){
        if(rightCount == n){
            list.add(new String(sb.toString()));
            return;
        }
        for(int i = 0; i <= 1; i++){
            if(leftCount <= n && rightCount <= n ){
                if(i == 0){
                    sb.append("(");
                    leftCount++;
                    DFS(list, sb, leftCount, rightCount, n);
                    leftCount--;
                    sb.deleteCharAt(sb.length() - 1);
                }
                if(i == 1 && rightCount < leftCount){
                    sb.append(")");
                    rightCount++;
                    DFS(list, sb, leftCount, rightCount, n);
                    rightCount--;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<String> list = generateParenthesis(3);
        int k = 1;
    }
}
