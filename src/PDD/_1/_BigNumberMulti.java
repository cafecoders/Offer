package PDD._1;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _BigNumberMulti {
    public static void main(String[] args){
        String str1 = "19287509125012";
        String str2 = "40241046016719";
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();

        System.out.println(getResult(chas1, chas2));//771500365000480482092033438
    }

    public static String getResult(char[] chas1, char[] chas2){
        if(chas1 == null || chas1.length == 0 || chas2 == null || chas2.length == 0){
            return "";
        }
        reverse(chas1);
        reverse(chas2);
        int[] val = new int[chas1.length + chas2.length];
        int[] carry = new int[chas1.length + chas2.length];
        for(int i = 0; i < chas1.length; i++){
            for(int j = 0; j < chas2.length; j++){
                val[i + j] += (chas1[i] - '0') * (chas2[j] - '0');
            }
        }

        for(int k = 0; k < chas1.length + chas2.length - 1; k++){
            int tmp = val[k] + (k > 0 ? carry[k-1] : 0);
            val[k] = tmp % 10;
            carry[k] = tmp / 10;
        }

        StringBuilder sb = new StringBuilder();
        if(carry[chas1.length + chas2.length -2] != 0){
            sb.append(carry[chas1.length + chas2.length -2]);
        }
        for(int i = chas1.length + chas2.length - 2; i >= 0; i--){
           sb.append(val[i]);
        }
        return sb.toString();
    }

    public static void reverse(char[] chas){
        int len = chas.length;
        for(int i = 0, j = len - 1; i < j; i++, j--){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }
    }
}
