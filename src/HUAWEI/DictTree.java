package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class DictTree {
    public static class TireNode{
        private boolean end;
        private Map<Character, TireNode> subNodes = new HashMap<>();;

        public void setEnd(boolean end){
            this.end = end;
        }

        public boolean isEnd(){
            return end;
        }

        public void setSubNodes(char c, TireNode node){
            subNodes.put(c, node);
        }

        public TireNode getSubNodes(char c){
            return subNodes.get(c);
        }
    }

    private static TireNode root = new TireNode();

    // construct TireTree
    public static void constructTree(String str) {
        char[] chas = str.toCharArray();
        TireNode tmpNode = root;
        for(int i = 0; i < chas.length; i++){
            TireNode node = root.getSubNodes(chas[i]);
            /*if(node == null){
                tmpNode.setSubNodes(chas[i], new TireNode());
            }
            tmpNode = node == null ? new TireNode() : node; 不能随意赋新节点，特指在tmp中新加的那个空节点*/

            if(node == null){ //如果node为空，将当前结点加到tmp节点上
                node = new TireNode();
                tmpNode.setSubNodes(chas[i], node);
            }
            tmpNode = node;


            if(i == chas.length - 1){
                tmpNode.setEnd(true);
            }
        }
    }

    public static void addWord(String lineTxt){
        TireNode tmpNode = root;

        for(int i = 0; i < lineTxt.length(); ++i){
            Character c = lineTxt.charAt(i);
            TireNode node = root.getSubNodes(c);
            if(node == null){
                node = new TireNode();
                tmpNode.setSubNodes(c, node);
            }
            tmpNode = node;

            if(i == lineTxt.length() - 1 )
                tmpNode.setEnd(true);
        }

    }

    public static boolean isSymbol(char c){
        int ic = (int) c;
        return (c == ' ') && ic < 0x2e80 || ic > 0x9fff;
    }

    public static String filter(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        int begin = 0;
        int pos = 0;
        TireNode tmpRoot = root;
        StringBuilder sb = new StringBuilder();
        while(pos < str.length()) {
            char c = str.charAt(pos);
            if(c == '@'){
                pos++;
                continue;
            }
            tmpRoot = tmpRoot.getSubNodes(c);
            if (tmpRoot == null) {
                sb.append(str.charAt(begin));
                pos = ++begin;
                tmpRoot = root;
            }else if(tmpRoot.isEnd()){
                sb.append("**");
                begin = ++pos;
                tmpRoot = root;
            }else {
                pos++;
            }
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    public static void main(String[] args){
        addWord("abc");
        addWord("ws");
        String str = "axxabfabcwsyy";
        System.out.println(filter(str));
    }
}
