package Fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class TestLinkedList {
    public static class MyLinkedList{
        static class Node{
            private Node next = null;
            private Object obj = null;
            public Node(Node next, Object obj){
                this.next = next;
                this.obj = obj;
            }
        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public void add(Object obj){
            if(head == null){
                head = new Node(null, obj);
                tail = head;
            }else {
                Node tmp = new Node(null, obj);
                tail.next = tmp;
                tail = tmp;
            }
            size++;
        }

        public void addFirst(Object obj){
            Node tmp = new Node(head, obj);
            head = tmp;
            size++;
        }

        public void addLast(Object obj){
            add(obj);
        }

        public Object remove(){
            if(tail == null){
                return null;
            }
            Object tmp = tail.obj;
            Node node = head;
            while(node.next != tail){
                node = node.next;
            }
            node.next = null;
            tail = node;
            size--;
            return tmp;
        }

        public boolean remove(Object o){
            if(tail == null){
                return false;
            }
            Node node = head;
            while(node.next != null && !node.next.obj.equals(o)){
                node = node.next;
            }
            node.next = node.next.next;
            size--;
            return true;
        }

        public boolean remove(int index){
            if(index >= size){
                return false;
            }
            Node node = head;
            while(index-- != 0){
                node = node.next;
            }
            node.next = node.next.next;
            size--;
            return true;

        }


        public String toString()
        {
            String str="【";
            Node temp=head;
            while(temp!=null)
            {
                if(temp!=tail)
                    str+=(temp.obj+",");
                else
                    str+=temp.obj;
                temp=temp.next;
            }
            str+="】";
            return str;
        }

    }
    public static void main(String[] args){
        /*MyLinkedList list = new MyLinkedList();
        for(int i = 0; i < 10; i++){
            list.add(String.valueOf(i*i));
        }
        System.out.print(list + " ");
        list.remove(2);
        System.out.print(list + " ");
        list.remove("64");
        System.out.print(list + " ");

        list.addFirst("100");
        System.out.print(list + " ");*/
        //ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < 5; i++){
            map.put(i, String.valueOf(i * i));
        }
        System.out.println(169^(169>>>4));
    }
}
