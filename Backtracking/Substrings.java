package Backtracking;

import java.util.Scanner;

public class Substrings {

    public static void subtrings(String str, String substring, int i){
        if(i==str.length()){
            System.out.println(substring);
            return;
        }
        subtrings(str, substring, i+1);
        subtrings(str, substring + str.charAt(i), i+1);
    }
    // public static void findSubtrings(String str, StringBuilder substring, int i){
    //     if(i==str.length()){
    //         System.out.println(substring);
    //         return;
    //     }
    //     findSubtrings(str, substring, i+1);
    //     findSubtrings(str, substring.append(str.charAt(i)), i+1);
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.next();
        subtrings(str, "", 0);
        
        //findSubtrings(str, new StringBuilder(), 0);
        sc.close();
    }
}
