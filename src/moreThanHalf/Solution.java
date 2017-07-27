package moreThanHalf;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int times = 0;
        int cand = -1;
        for(int i = 0; i < array.length; i++){
            if(cand == -1){
                cand = array[i];
                times++;
            }else if(array[i] == cand){
                times++;
            }else{
                //cand = -1;
               if(times > 0){
                   times--;
               }else{
                   cand = -1;
               }
            }
        }

        int count = 0;

        for(int i = 0; i < array.length; i++){
            if(cand == array[i])
                count++;
        }

        return count > array.length/2 ? cand : 0;
    }

    public static void main(String [] args){
        int[] arr = {1,2,3,2,2,2,5,4};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
