package Heaps;

import java.util.PriorityQueue;

public class WeakestSoldier {

    public static class Row implements Comparable<Row>{
        int id;
        int soldiers;

        Row(int id, int soldiers){
            this.id = id;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Row R2){
            if(this.soldiers == R2.soldiers){
                return this.id - R2.id;
            }
            return this.soldiers - R2.soldiers;
        }
    }
    
    public static void main(String[] args) {
        int rows[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < rows.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < rows[i].length; j++) {
                soldiers+=rows[i][j];
            }
            pq.add(new Row(i, soldiers));
        }

        for (int j = 0; j < k; j++) {
            System.out.println(pq.remove().id);
        }

    }
}
