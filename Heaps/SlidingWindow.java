package Heaps;

import java.util.PriorityQueue;

public class SlidingWindow {

    public static class Pair implements Comparable<Pair>{
        int idx;
        int value;

        Pair(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        @Override

        public int compareTo(Pair P2){
            return P2.value - this.value;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, arr[i]));
        }

        int ans[] = new int[arr.length-k+1];
        ans[0] = pq.peek().value;

        for (int i = k; i < arr.length; i++) {
            while(pq.peek().idx <= i-k){
                pq.remove();
            }
            pq.add(new Pair(i, arr[i]));
            ans[i-k+1] = pq.peek().value;
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
