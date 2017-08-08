package ZUOs;

import HUAWEI.DictTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class _3_5_TrieTree {
    public static class TrieNode{
        private boolean end;
        private Map<Character, TrieNode> map = new HashMap<>();

        public void setEnd(boolean end){
            this.end = end;
        }

        public boolean isEnd(){
            return end;
        }

        public void addSubNodes(char c, TrieNode node){
            map.put(c, node);
        }

        public TrieNode getSubNodes(char c){
            return map.get(c);
        }

        public boolean hasSubNodes(){
            return map.size() > 0;
        }
    }

    private static TrieNode rootNode = new TrieNode();

    public static boolean constructTree(String str){
        if(str == null || str.length() == 0){
            return false;
        }
        char[] chas = str.toCharArray();
        TrieNode tmpNode = rootNode;
        for(int i = 0; i < chas.length; i++){
            TrieNode node = tmpNode.getSubNodes(chas[i]);
            if(node == null){
                node = new TrieNode();
                tmpNode.addSubNodes(chas[i], node);
            }
            tmpNode = node;

            if(tmpNode.isEnd()){
                return true;
            }
            if(i == chas.length - 1 ){
                tmpNode.setEnd(true);
                if(tmpNode.hasSubNodes()){
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args){
        String[] strs = {"pan", "wan", "sheng","pans"};
        boolean flag = false;
        for(int i = 0; i < strs.length; i++){
            if(constructTree(strs[i])){
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }
}
