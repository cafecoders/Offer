package DoublePow;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        boolean isMinus = false;
        if(exponent < 0){
            isMinus = true;
            exponent = Math.abs(exponent);
        }
        double res = Power(base, exponent>>1);
        res *= res;
        if((exponent & 0x01) == 1){
            res *= base;
        }
        return isMinus ? 1.0/res : res;
    }

    public static void main(String[] args){
        double base = 0;
        int exponent = 1;
        System.out.println(Power(base, exponent));
    }
}
