package Fun;

import java.io.*;

/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class InputOutput {
    public static void main(String[] args){
        try {
            //FileInputStream fileInputStream = new FileInputStream(new File("E:\\words.txt"));
           // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((new FileInputStream(new File("E:\\words.txt")) {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            })));
            String str = null;
            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
