package Backtracking;

import java.util.Scanner;

public class Permutations {

    public static void findPermutaions(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutaions(newStr, ans+str.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.next();
        findPermutaions(str, "");
        sc.close();
    }
}
