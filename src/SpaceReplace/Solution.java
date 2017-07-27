package SpaceReplace;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class Solution {
    public static String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return null;
        }

        int len = str.length();
        int numOfSpace = 0;
        char[] chas = (str.toString()).toCharArray();
        for(int i = 0; i < len; i++){
            if(chas[i] == ' '){
                numOfSpace++;
            }
        }
        char[] res = new char[chas.length + 2* numOfSpace];
        int index = res.length - 1;
        for(int j = chas.length-1; j > -1; j--){
            if(chas[j] != ' '){
                res[index--] = chas[j];
            }else {
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("we are happy!");
        System.out.println(replaceSpace(sb));
    }
}
