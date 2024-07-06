import java.util.LinkedList;
import java.util.*;
public class FirstNonRepeatingChar {

    public static void printFirstNonRepeatingChar(String str){
        int[] frequency = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            q.add(c);
            frequency[c-'a']++;
            while(!q.isEmpty() && frequency[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println(-1);
            } else {
                System.out.println(q.peek());
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printFirstNonRepeatingChar(str);
    }
}
