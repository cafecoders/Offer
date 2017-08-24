package Fun;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class DeleteNum {
    public static List<Character> deleteK(char[] num, int k){
        List<Character> list = new LinkedList<>();
        for(int i = 0; i < num.length; i++){
            list.add(num[i]);
        }

        int index = 0;
       /* for(int i = 0; i < num.length - 1; i++){
            if(num[i] < num[i+1]){
                index = i;
                break;
            }
            else{
                index = num.length - 1;
            }
        }*/
        while(k != 0){

            if(index == list.size() - 1){
                break;
            }

            if(list.get(index) < list.get(index+1)){
                list.remove(index--);
                index = index < 0 ? 0 : index;
                k--;
            }else if(list.get(index) > list.get(index+1)){
                index++;
            }else{
                index++;
            }

        }

        return list;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();
            char[] chas = str.toCharArray();
            int k = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            List<Character> list = deleteK(chas, k);
            for(Character c : list){
                sb.append(c);
            }
            System.out.println(sb.toString().substring(0, str.length() - k));


    }
}
