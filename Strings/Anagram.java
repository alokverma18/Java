//lowerCase letters only

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    
    public static boolean isAnagram(String a, String s){
        char x[] = a.toCharArray();
        char y[] = s.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String a = sc.next();
        System.out.print("Enter another String : ");
        String b = sc.next();
        System.out.println(isAnagram(a, b));
        sc.close();
    }
}
