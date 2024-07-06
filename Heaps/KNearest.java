package Heaps;

import java.util.PriorityQueue;

public class KNearest {
    
    public static class Point implements Comparable<Point> {
        int idx;
        int x;
        int y;
        int dist;

        Point(int idx, int x, int y, int dist){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point P2){
            return this.dist - P2.dist;
        }

    }


    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        for (int i = 0; i < pts.length; i++) {
            int dist = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(i, pts[i][0], pts[i][1], dist));
        }

        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove().idx);
        }
    }
}
