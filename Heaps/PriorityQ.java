package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(15);
        pq.add(17);
        pq.add(16);
        pq.add(20);

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        System.out.println();

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(15);
        pq2.add(17);
        pq2.add(16);
        pq2.add(20);

        while(!pq2.isEmpty()){
            System.out.println(pq2.remove());
        }
        System.out.println();

        PriorityQueue<String> pq3 = new PriorityQueue<>(Comparator.reverseOrder());
        pq3.add("A");
        pq3.add("C");
        pq3.add("B");
        pq3.add("D");

        while(!pq3.isEmpty()){
            System.out.println(pq3.remove());
        }
        System.out.println();
    }
}
