package Fun;

import java.io.*;

/**
 * Created by missinghigh on 2017/8/27.
 */
public class FileRead {
    public static void main(String[] args){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("E:\\SpringDemo\\Offer\\out\\production\\Offer\\Fun\\words.txt"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String str;
            try {
                while((str = bufferedReader.readLine()) != null){
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
