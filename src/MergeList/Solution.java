package MergeList;
import ListNode.ListNode;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null){
            if(list1 == null){
                return list2;
            }else
                return list1;
        }
        ListNode head = list1.val > list2.val ? list2 : list1;
        ListNode cur1 = list1.val > list2.val ? list2 : list1;
        ListNode cur2 = list1.val > list2.val ? list1 : list2;

        ListNode pre = cur1, next;

        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                pre = cur1;
                cur1 = cur1.next;
            }else{
                next = cur2.next;
                pre.next = cur2;
                pre = cur2;
                cur2.next = cur1;
                cur2 = next;
            }
        }

        if(cur1 == null) {
            pre = cur2;
        }else{
            pre = cur1;
        }

        return head;
    }

    public static ListNode Merge2(ListNode list1, ListNode list2){
        if(list1 == null || list2 == null){
            if(list1 == null){
                return list2;
            }else
                return list1;
        }
        ListNode head = null;

        if(list1.val <= list2.val){
            head = list1;
            head.next = Merge2(list1.next, list2);
        }else{
            head = list2;
            head.next = Merge2(list1, list2.next);
        }

        return head;
    }


    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);

        ListNode list = Merge2(list1, list2);
        while(list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
