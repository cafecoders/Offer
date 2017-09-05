package Fun;

import java.io.File;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class FileTest {
    public static void main(String[] args){
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
        System.out.println(minCost(costs));
        File file = new File("E:\\");
        File[] fileLists = file.listFiles();
        for(File f : fileLists){
            if(f.isFile())
                System.out.println("File " + f);
            if(f.isDirectory())
                System.out.println("Directory: " + f);
        }
    }

    public static int minCost(int[][] costs) {
        // Write your code here
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int back0 = 0, back1 = 0, back2 = 0;

            back0 = costs[0][0];
            back1 = costs[0][1];
            back2 = costs[0][2];

        for(int i = 1; i < n; i++){
            back0 = Math.min(costs[i-1][2], costs[i-1][1]) + costs[i][0];
            back1 = Math.min(costs[i-1][2], costs[i-1][0]) + costs[i][1];
            back2 = Math.min(costs[i-1][0], costs[i-1][1]) + costs[i][2];
            costs[i][0] = back0;
            costs[i][1] = back1;
            costs[i][2] = back2;

        }
        return Math.min(back0, Math.min(back1, back2));
    }
}
