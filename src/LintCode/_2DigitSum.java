package LintCode;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class _2DigitSum {
    public static String addBinary(String a, String b) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        a = reverse(a);
        b= reverse(b);
        int index = 0, ia = 0, ib = 0;
        int digit = 0;
        int carry = 0;
        while(index < a.length() || index < b.length()){
            char ca = index < a.length() ? a.charAt(index) : '0';
            char cb = index < b.length() ? b.charAt(index) : '0';
            if(ca == '0' && cb == '0'){
                digit = carry;
                carry = 0;
                sb.append(digit);
            }else if(ca == '1' && cb == '1'){
                digit = carry;
                carry = 1;
                sb.append(digit);
            }else{
                digit = carry == 0 ? 1 : 0;
                sb.append(digit);
            }
            index++;
        }
        if(carry == 1){
            sb.append(1);
        }
        return reverse(sb.toString());
    }

    public static String reverse(String str){
        char[] chas = str.toCharArray();
        for(int i = 0, j = str.length() - 1; i < j; i++, j--){
            char tmp = chas[i];
            chas[i] = chas[j];
            chas[j] = tmp;
        }

        return String.valueOf(chas);
    }

    public static void main(String[] args){
        String a = "111";
        String b = "111";
        System.out.println(addBinary(a, b));
    }
}
