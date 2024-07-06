//check palindrome after removing non alphaNumeric chars

import java.util.Scanner;

public class StringPalindrome {
    public static boolean isPalindrome(String str){
        StringBuilder s = new StringBuilder("");

        for(int i=0; i<str.length(); i++){
            if(Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i))){
                s.append(Character.toLowerCase(str.charAt(i)));
            }
        }

        if(s.toString().equals(s.reverse().toString())){
            return true; 
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.nextLine();
        System.out.println(isPalindrome(str));

        sc.close();
    }
}
