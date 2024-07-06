package Stack;
import java.util.Stack;

public class Stocks {

    public static void calculateSpan(int[] stocks, int[] span){
        span[0] = 1;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=1; i<stocks.length; i++){
            int curPrice = stocks[i];
            while(!s.isEmpty() && curPrice>=stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        
        int[] stocks = new int[] {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        
        calculateSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
