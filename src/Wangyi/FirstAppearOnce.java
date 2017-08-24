package Wangyi;

/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class FirstAppearOnce {
    private static int[] map = new int[256];
    private static StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        sb.append(ch);
        map[ch]++;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        String str = sb.toString();
        for(int i = 0; i < str.length(); i++){
            if(map[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args){
        String str = "helloworld";
        for(int i = 0; i < str.length(); i++){
            Insert(str.charAt(i));
            System.out.print(FirstAppearingOnce());
        }
    }
}
