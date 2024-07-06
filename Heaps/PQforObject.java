package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQforObject {
    
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }

        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("S", 16));
        pq.add(new Student("X", 20));
        pq.add(new Student("A", 17));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " " + pq.peek().rank);
            pq.remove();
        }

    }
}
