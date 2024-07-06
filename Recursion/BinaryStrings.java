package Recursion;

import java.util.Scanner;

public class BinaryStrings {

    public static void printBinaryStrings(int n, String str, int last){
        if (n==0){
            System.out.println(str);
            return;
        }
        printBinaryStrings(n-1, str+"0", 0);
        if(last == 0){
            printBinaryStrings(n-1, str+"1", 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        
        printBinaryStrings(n, new String(), 0);

        sc.close();
    }
}
