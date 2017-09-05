package LintCode;

/**
 * Created by Administrator on 2017/9/1 0001.
 */
public class CrossStrings {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if((s3 == null && (s1 != null || s2 != null)) || (s3.length() != s1.length() + s2.length())){
            return false;
        }
        char[] chas1 = s1.toCharArray();
        char[] chas2 = s2.toCharArray();
        char[] chas3 = s3.toCharArray();
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int j = 1; j < s2.length()+ 1; j++){
            if(chas2[j-1] == chas3[j-1])
                dp[0][j] =  true && dp[0][j-1];
        }
        for(int i = 1; i < s1.length() + 1; i++){
            if(s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] =  true && dp[i-1][0];
        }

        for(int i = 1; i < chas1.length + 1; i++){
            for(int j = 1; j < chas2.length + 1;j++){
                dp[i][j] = ( dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ) ||
                        ( dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j+i-1) );
            }
        }
        return dp[chas1.length][chas2.length];
    }

    public static void main(String[] args){
        String s1 = "aacaac";
        String s2 = "aacaaeaac";
        String s3 = "aacaaeaaeaacaac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
