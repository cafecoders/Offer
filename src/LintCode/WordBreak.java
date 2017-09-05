package LintCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/4 0004.
 */
public class WordBreak {
    public static void main(String[] args){
        String  s = "lintcode";
        Set<String> set = new HashSet<>();
        set.add("lints");
        set.add("co");
        set.add("code");
        set.add("lint");
        System.out.println(wordBreak(s, set));
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        if ((s == null || s.length() == 0) && (dict == null || dict.size() == 0))
            return true;
        return wordBreak(s, dict, 0);
    }

    public static boolean wordBreak(String s, Set<String> dict, int start) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;// 初始值
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i])
                continue;
            for (String t : dict) {
                int len = t.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if (s.substring(i, end).equals(t)) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
