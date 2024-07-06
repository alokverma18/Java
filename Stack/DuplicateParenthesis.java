package Stack;

import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean hasDuplicates(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println("Ch : " + ch);
            if(ch!=')'){
                s.push(ch);
            } else {
                if(s.peek()=='('){
                    return true;
                }
                while(s.peek()!='('){
                    s.pop();
                }
                s.pop();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "(((a+b)+((c)+(d))))";
        System.out.println(hasDuplicates(str));
    }
}
