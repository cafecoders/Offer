package ZUOs;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class _4_4_StringCalculator {
    public static int getValue(String str){
        char[] chas = str.toCharArray();
        return value(chas, 0)[0];
    }

    public static int[] value(char[] chas, int i){
        LinkedList<String> list = new LinkedList<>();
        int pre = 0;
        while(i < chas.length && chas[i] != ')'){
            if(chas[i] <= '9' && chas[i] >= '0'){
                pre = pre * 10 + chas[i++] - '0';
            }else if(chas[i] != '('){
                addNum(list, pre);
                list.addLast(String.valueOf(chas[i++]));
                pre = 0;
            }else{
                int[] bra = value(chas, i+1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(list, pre);
        return new int[] {getNum(list), i};
    }

    public static void addNum(LinkedList<String> list, int num){
        if(!list.isEmpty()){
            int cur = 0;
            String str = list.pollLast();
            if(str.equals("+") || str.equals("-")){
                list.addLast(str);
            }else if(str.equals("*") || str.equals("/")){
                cur = Integer.parseInt(list.pollLast());
                num = str.equals("*") ? (num * cur) : (cur / num);
            }

        }
        list.addLast(String.valueOf(num));
    }

    public static void addNum1(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> list){
        int res = 0;
        boolean add = true;
        int num = 0;
        while(!list.isEmpty()){
            String cur = list.poll();
            if(cur.equals("+")){
                add = true;
            }else if(cur.equals("-")){
                add = false;
            }else{
                num = Integer.parseInt(cur);
                res += add ? num : -num;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String str = "3+4+((6-7)*2)";
        System.out.println(getValue(str));
    }
}
