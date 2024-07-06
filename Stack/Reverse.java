package Stack;
import java.util.Stack;

public class Reverse {

    public static void pushAtBottom(Stack<Integer> s, int n){
        if(s.isEmpty()){
            s.push(n);
            return;
        }
        int x = s.pop();
        pushAtBottom(s, n);
        s.push(x);
    }

    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int x = s.pop();
        reverse(s);
        pushAtBottom(s, x);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        pushAtBottom(s, 0);
        pushAtBottom(s, 1);
        pushAtBottom(s, 2);
    
        System.out.println(s);

        reverse(s);

        System.out.println(s);
    }
}
