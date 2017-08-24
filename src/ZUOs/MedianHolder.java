package ZUOs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class MedianHolder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianHolder(){

    }

    public String getMedian(){

        if(maxHeap.size() == minHeap.size()){
            return String.valueOf((maxHeap.peek() + minHeap.peek()) * 0.5);
        }else if(maxHeap.size() < minHeap.size()){
            return String.valueOf(minHeap.peek());
        }
        return String.valueOf(maxHeap.peek());

    }

    public void addElement(int number){
        if(maxHeap.isEmpty()){
            maxHeap.add(number);
            return;
        }
        if(maxHeap.peek() >= number){
            maxHeap.add(number);
        }else{
            if(minHeap.isEmpty()){
                minHeap.add(number);
            }else if (minHeap.peek() > number){
                maxHeap.add(number);
            }else {
                minHeap.add(number);
            }
        }

        if(maxHeap.size() == minHeap.size() + 2){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() == minHeap.size() - 2){
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args){
        MedianHolder medianHolder = new MedianHolder();
        int[] arr = {1,3,7,5,2,8,4,9,0,6};
        for(int i = 0; i < arr.length; i++){
            medianHolder.addElement(arr[i]);
            System.out.print(medianHolder.getMedian() + " ");

        }
    }

}
