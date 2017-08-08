package HUAWEI;

import java.util.*;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _18SentenceSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(transform(str));
        }
    }

    public static String transform(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        char[] chas = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < chas.length; i++){
            if(chas[i] <= 'z' && chas[i] >= 'a' || chas[i] <= 'Z' && chas[i] >= 'A'){
                list.add(chas[i]);
            }
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                 return (o1 < 91 ? o1 + 32 : o1) - (o2 < 91 ? o2 + 32 : o2);
            }
        });

        int index = 0;
        for(int i = 0; i < chas.length; i++){
            if(chas[i] <= 'z' && chas[i] >= 'a' || chas[i] <= 'Z' && chas[i] >= 'A'){
                chas[i] = list.get(index++);

            }
        }
        list.clear();
        return String.valueOf(chas).substring(0, str.length());
    }


}
