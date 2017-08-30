package Fun;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class TestArrayList {
    static class MyArrayList{
        private Object[] value = null;
        private int size = 0;
        public MyArrayList(){
            value = new Object[10];
        }

        public boolean add(Object val){
            if(size == value.length){
                expansion();
            }
            value[size++] = val;
            return true;
        }

        public boolean remove(int index){
            if(index < 0 || index >= size){
                return false;
            }
            Object[] tmp = new Object[size - 1];
            for(int i = 0, j = 0; i < size; i++){
                if(i != index){
                    tmp[j++] = value[i];
                }
            }
            value = tmp;
            size--;
            return true;
        }

        public boolean remove(Object val){
            for(int i = 0; i < size; i++){
                if(value[i] == val){
                    remove(i);
                    return true;
                }
            }
            return false;
        }

        public boolean set(int index, Object val){
            if(index < 0 || index >= size){
                return false;
            }
            value[index] = val;
            return true;
        }

        public Object get(int index){
            if(index < 0 || index >= size){
                return null;
            }
            return value[index];
        }

        public int size(){
            return size;
        }

        public boolean expansion(){
            int newSize = size + (size >> 1);
            Object[] tmp = new Object[newSize];
            //System.arraycopy(tmp, 0, value, 0, size);
            for(int i = 0; i < size; i++){
                tmp[i] = value[i];
            }
            value = tmp;
            //size = newSize;
            return true;
        }
    }
    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        for(int i = 0; i < 10; i++){
            list.add(i*i);
        }
        list.add(1000);
        for(int i = list.size-1; i >= 0; i--)
            System.out.println(list.get(i));
    }
}
