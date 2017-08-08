package ZUOs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class _3_3_OnesInMatrix {
    public static int maxRecSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, getMax(height));
        }

        return maxArea;
    }

    public static int getMax(int[] height){
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> lMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> rMap = new HashMap<Integer, Integer>();
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            while(!s.isEmpty() && height[i] <= height[s.peek()]){
                int pop = s.pop();
                int top = s.isEmpty() ? -1 : s.peek();
                //lMap.put(pop, top);
                //rMap.put(pop, i);
                int curArea = (i - top - 1) * height[pop];
                maxArea = Math.max(maxArea, curArea);
            }
            s.push(i);
            //maxArea = Math.max(maxArea, height[i] * (rMap.get(i) - lMap.get(i) - 1));
        }

        while(!s.isEmpty()){
            int pop = s.pop();
            int top = s.isEmpty() ? -1 : s.peek();
            //rMap.put(pop, top);
            //rMap.put(pop, -1);
            int curArea = (height.length - top - 1) * height[pop];
            maxArea = Math.max(maxArea, curArea);
        }



        return maxArea;
    }

    public static void main(String[] args){
        int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
        System.out.println(maxRecSize(map));
    }
}
