package Fun;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class SensitiveService {


    public static void afterPropertiesSet()  {
        try{
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");
            InputStreamReader read = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(read);
            String lineTxt;
            while((lineTxt = bufferReader.readLine()) != null){
                addWord(lineTxt.trim());
            }
            bufferReader.close();
            read.close();
        }catch(Exception e){
            e.getMessage();
        }
    }

    private  static TireNode rootNode = new TireNode();

    public static void addWord(String lineTxt){
        TireNode tmpNode = rootNode;

        for(int i = 0; i < lineTxt.length(); ++i){
            Character c = lineTxt.charAt(i);
            TireNode node = rootNode.getSubNodes(c);
            if(node == null){
                node = new TireNode();
                tmpNode.setSubNodes(c, node);
            }
            tmpNode = node;

            if(i == lineTxt.length() - 1 )
                tmpNode.setEnd(true);
        }

    }


    public static class TireNode{
        // char val;
        private  boolean end = false;
        private Map<Character, TireNode> subNodes = new HashMap<Character, TireNode>();

        public void setSubNodes(Character key, TireNode node){
            subNodes.put(key, node);
        }

        public TireNode getSubNodes(Character key){
            return subNodes.get(key);
        }

        public boolean isWordEnd(){
            return end;
        }

        public void setEnd(boolean end){
            this.end = end;
        }
    }

    public static String filter(String lineTxt){

        int begin = 0;
        int position = 0;
        TireNode tmpNode = rootNode;
        String replacement = "**";
        StringBuilder sb = new StringBuilder();

        while(position < lineTxt.length()){
            char c = lineTxt.charAt(position);

            tmpNode = tmpNode.getSubNodes(c);
            if(tmpNode == null){
                sb.append(lineTxt.charAt(begin));
                position = begin + 1;
                begin = position;
                tmpNode = rootNode;
            }else if(tmpNode.isWordEnd()){
                sb.append(replacement);
                position = position + 1;
                begin = position;
                tmpNode = rootNode;
            }else{
                position++;
            }
        }
        sb.append(lineTxt.substring(begin));
        return sb.toString();

    }

    public static void main(String[] args){
       // SensitiveService s = new SensitiveService();
        afterPropertiesSet();
        System.out.print(filter("pws"));
    }
}

