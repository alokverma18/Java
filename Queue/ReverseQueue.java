import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.add(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(9);
        q.add(1);
        q.add(6);
        q.add(1);
        q.add(7);

        reverse(q);

        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }
}
