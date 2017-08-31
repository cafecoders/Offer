package LintCode;

import Fun.IntegerLock;

/**
 * Created by missinghigh on 2017/8/30.
 */
public class FindMissing2 {
    public static void main(String[] args){
        int n = 11;
        String str  = "111098765432";
        System.out.println(findMissing2(n, str));
    }
    public static int findMissing2(int n, String str) {
        // Write your code here
        int start = 0;
        int[] res = new int[1];
        boolean[] isVisited = new boolean[n+1];
        DFS(n, str, start, isVisited, res);
        return res[0] == 0 ? -1 : res[0];
    }

    public static int getNum(String str, int start, int i){
        if(str.charAt(start) == '0')
            return 0;
        String sub = str.substring(start, start + i);
        return Integer.parseInt(sub);
    }

    public static int DFS(int n, String str, int start, boolean[] isVisited, int[] res){
        if(start >= str.length()){
            int count = 0;
            int index = 0;
            for(int i = 1; i < n+1; i++){
                if(!isVisited[i]){
                    count++;
                    index = i;
                }
            }
            if(count == 1){
                res[0] = index;
                return index;
            }else{
                return -1;
            }
        }

        for(int i = 2; i >= 1; i--){
            if(start + i > str.length())
                continue;
            int num = getNum(str, start, i);
            if(num >= 1 && num <= n && !isVisited[num]){
                isVisited[num] = true;
                start += i;
                DFS(n, str, start, isVisited, res);
                start -= i;
                isVisited[num] = false;
            }
        }

        return -1;
    }
}
