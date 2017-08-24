package Wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class PlaceCake {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int[][] map = new int[W][H];
        int count = 0;
        for(int i = 0; i < W; i++){
            for(int j = 0; j < H; j++){
                if((i%4 == 0 || i % 4 == 1) && (j %4 == 0 || j % 4 == 1)){
                    map[i][j] = 1;
                    count++;
                }
                if((i%4 == 2 || i % 4 == 3) && (j %4 == 2 || j % 4 == 3)){
                    map[i][j] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
