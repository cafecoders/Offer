package isBSTsequence;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return process(sequence, 0, sequence.length - 1);
    }

    public static boolean process(int[] sequence, int start, int end){
        if(end <= start)
            return true;
        int last = sequence[end];
        int index = end;
        for(int i = start; i <= end; i++){
            if(sequence[i] > last){
                index = i;
                break;
            }
        }
        for(int i = index; i < end; i++){
            if(sequence[i] < last){
                return false;
            }
        }
       // boolean left = process(sequence, start, index - 1);
       // boolean right = process(sequence, index, end - 1);
        return process(sequence, start, index - 1) && process(sequence, index, end - 1);
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,8,8,7,5};
        System.out.println(VerifySquenceOfBST(arr));
    }
}
