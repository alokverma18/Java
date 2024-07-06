import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
    
    public static boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if (c=='('){
                stack.push(')');
            }
            else if (c=='{'){
                stack.push('}');
            }
            else if (c=='['){
                stack.push(']');
            }
            else if (stack.isEmpty() || c!=stack.pop()){
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String s = sc.next();
        System.out.println(validParenthesis(s));
        sc.close();
    }
}
