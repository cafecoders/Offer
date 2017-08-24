package Fun;

import sun.text.normalizer.Trie;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/21 0021.
 */
public class TrieTree {
    public static class TrieNode{
        private boolean isEnd;
        private HashMap<Character, TrieNode> subNodes= new HashMap<>();

        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }
        public boolean getEnd(){
            return this.isEnd;
        }
        public void addSubNodes(char c, TrieNode node){
            subNodes.put(c, node);
        }
        public TrieNode getSubNodes(char c){
            return subNodes.get(c);
        }
    }

    private static TrieNode rootNode = new TrieNode();

    public static void constructTree(String str) throws IOException {

        char[] chas = str.toCharArray();
        TrieNode tmpNode = rootNode;
        for(int i = 0; i < chas.length; i++){
            TrieNode node = tmpNode.getSubNodes(chas[i]);
            if(null == node){
                node = new TrieNode();
                tmpNode.addSubNodes(chas[i], node);
            }
            tmpNode = node;
            if(i == chas.length - 1){
                tmpNode.setEnd(true);
            }
        }

    }

    public static void addWords() throws FileNotFoundException {
        //InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("words.txt");
        FileInputStream fi = new FileInputStream("E:\\words.txt");
        InputStreamReader ir = new InputStreamReader(fi);
        BufferedReader bufferedReader = new BufferedReader(ir);
        String lineTxt;
        try {
            while((lineTxt = bufferedReader.readLine()) != null){
                constructTree(lineTxt);
            }

            bufferedReader.close();
            ir.close();
            fi.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String filter(String str){
        StringBuilder sb = new StringBuilder();
        char[] chas = str.toCharArray();
        int pos = 0;
        int begin = 0;
        TrieNode root = rootNode;
        String replacement = "**";
        while(pos < chas.length){
            char c = chas[pos];
            root = root.getSubNodes(c);
            if(root == null){
                sb.append(c);
                pos = ++begin;
                root = rootNode;
            }else if(root.getEnd()){
                sb.append(replacement);
                begin = ++pos;
                root = rootNode;
            }else{
                pos++;
            }
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    public static void main(String[] args){
        String str = "abcabfpwsyy";
        try {
            addWords();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(filter(str));
    }
}
