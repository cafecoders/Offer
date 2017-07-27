package ReversePrintList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/24 0024.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }

        ListNode pre = null;
        ListNode next = null;
        while(listNode != null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }

        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }

        return list;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);

        ArrayList<Integer> list = printListFromTailToHead(node1);
        for(Integer i : list){
            System.out.println(i);
        }
    }

    /**
     *   ArrayList<Integer> list = new ArrayList<Integer>();
     public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
     ListNode head = listNode;
     ArrayList<Integer> list = new ArrayList<Integer>();
     if (head == null)
     return list;

     //ArrayList<Integer> list = new ArrayList<Integer>();
     Stack<Integer> stack = new Stack<Integer>();
     while(head != null){
     stack.push(head.val);
     head = head.next;
     }

     while(!stack.isEmpty()){
     list.add(stack.pop());
     }

     return list;
     }
     */

}
