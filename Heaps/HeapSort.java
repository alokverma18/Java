import java.util.PriorityQueue;

public class HeapSort {

    public static void heapify(int arr[], int i, int n){

        int l = 2*i+1;
        int r = 2*i+2;
        int maxIdx = i;

        //Ascending

        if(l<n && arr[l]>arr[i]){
            maxIdx = l;
        }

        if(r<n && arr[r]>arr[i]){
            maxIdx = r;
        }

        //Descending

        // if(l<n && arr[l]<arr[i]){
        //     maxIdx = l;
        // }

        // if(r<n && arr[r]<arr[i]){
        //     maxIdx = r;
        // }

        if(maxIdx!=i){
            int t = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = t;

            heapify(arr, maxIdx, n);
        }
    }
    
    public static void sort(int[] arr){

        //build max-heap
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        //swap largest element
        for(int i=n-1; i>=0; i--){
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {

        int arr[] = {1, 9, 1, 6, 7};
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
