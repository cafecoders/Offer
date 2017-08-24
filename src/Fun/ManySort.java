package Fun;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class ManySort {

    public static void main(String [] args){
        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        //bubbleSort(arr);
        //InsertionSort(arr);
        //SelectionSort(arr);
        mergeSort(arr, 0, arr.length-1);
        //quickSort(arr, 0, arr.length - 1);
        //heapSort(arr);
        for(int i : arr){
            System.out.print(i + " "
            );
        }
    }
    public static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void InsertionSort(int[] arr){
        for(int i =1; i < arr.length; i++){
            int j = i;
            int tmp = arr[j];
            while(arr[j - 1] > tmp){
                arr[j] = arr[--j];
            }
            arr[j] = tmp;
        }
    }

    public static void SelectionSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);

        }

    }

    public static void swap(int[] arr, int a, int v){
        int tmp = arr[a];
        arr[a] = arr[v];
        arr[v] = tmp;
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static int count;
    public static void merge(int[] arr, int start, int mid, int end){
        int leftLen = mid - start + 1;
        int rightLen = end - mid;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        int l = 0, r = 0, index = start;
        for(int i = start; i <= end; i++){
            if(i <= mid){
                leftArr[l++] = arr[i];
            }else{
                rightArr[r++] = arr[i];
            }
        }
        for(l = 0, r= 0; l < leftLen && r < rightLen;){
            if(leftArr[l] > rightArr[r]){
                arr[index++] = rightArr[r++];
            }else{
                arr[index++] = leftArr[l++];
            }
        }
        if(l == leftLen){
            while(index <= end){
                arr[index++] = rightArr[r++];
            }
        }
        if(r == rightLen ){
            while(index <= end){
                arr[index++] = leftArr[l++];
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int left = start;
        int right = end-1;

        while(true){
            while(left <= end && arr[left] < arr[end]){
                left++;
            };

            while(right >= start && arr[right] > arr[end]){
                right--;
            };

            if(left >= right){
                break;
            }

            swap(arr, left, right);
        }
        swap(arr, left, end);

        return left;
    }

    public static void heapSort(int[] arr){
        int len = arr.length;
        int pos = (len-1)/2;
        for(int i = pos; i >= 0; i--){
            heapify(arr, len-1, i);
        }

        for(int i= len - 1; i >= 0; i--){
            swap(arr, 0, i);
            heapify(arr, i - 1, 0);
        }

    }

    public static void heapify(int[] arr, int len, int pos){
        int child;
        while(2 * pos + 1 <= len){
            child = 2 * pos + 1;
            while(child < len && arr[child] < arr[child+1]){
                child++;
            }
            if(arr[pos] < arr[child]){
                swap(arr, pos, child);
            }else{
                break;
            }

            pos = child;
        }
    }


}
