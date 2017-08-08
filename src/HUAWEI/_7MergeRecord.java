package HUAWEI;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class _7MergeRecord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int[][] record = new int[num][2];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i = 0; i < num; i++){
                record[i][0] = sc.nextInt();
                record[i][1] = sc.nextInt();
                if(map.containsKey(record[i][0])){
                    map.put(record[i][0], record[i][1] + map.get(record[i][0]));
                }else {
                    map.put(record[i][0], record[i][1]);
                }
            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        }
    }
}
