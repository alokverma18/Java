package Recursion;

import java.util.Scanner;

public class RemoveDuplicates {
    
    public static String remove(String str, int i, StringBuilder s, boolean[] track){

        if(i == str.length()){
            return s.toString();
        }
        if (track[str.charAt(i)-'a']==false){
            track[str.charAt(i)-'a'] = true;
            s.append(str.charAt(i));
        }
        return remove(str, i+1, s, track);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.next();
        System.out.println(remove(str, 0, new StringBuilder(), new boolean[26]));

        sc.close();
    }
}
