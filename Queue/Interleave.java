import java.util.Queue;
import java.util.LinkedList;
public class Interleave {

    public static void interleave(Queue<Integer> q){
        Queue<Integer> q2 = new LinkedList<>();
        int n = q.size();
        for(int i=0; i<n/2; i++){
            q2.add(q.remove());
        }

        while(!q2.isEmpty()) {
            q.add(q2.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        interleave(q);

        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }

    }
}
