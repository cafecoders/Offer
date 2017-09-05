package LintCode;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
public class NumEncodings {
    public static int numDecodings(String s) {
        // write your code here
        if(0 == s.length()) return 0;

        if(s.charAt(0)=='0') return 0;
        if(s.length() == 1)
            return 1;

        int []dp = new int[s.length()];//记录遍历到字符串第i位置时的状态（该状态指的是编码的方法数）
        dp[0] = 1;

        for(int i=1;i<s.length();i++){

            String temp = s.substring(i-1, i+1);// 取i位和i-1位
            int num = Integer.parseInt(temp);
            if(num == 0){
                return 0;
            }else if(1 <= num && num <= 9)
                dp[i] = dp[i-1];
            else if(11 <= num && num <= 19 || num >=21 && num <= 26)
                dp[i] = dp[i-1] + (i - 2 >= 0 ? dp[i-2] : 1);
            else if(num % 10 == 0)
                if(num/10 >= 3 )
                    return 0;
                else
                    dp[i] = i - 2 >= 0 ? dp[i-2] : 1;
            else
                dp[i] = dp[i-1];
        }
        return dp[s.length()-1];
    }


    public static void main(String[] args){
        String s = "192611";
        System.out.println(numDecodings(s));
    }
}
