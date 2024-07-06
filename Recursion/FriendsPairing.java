package Recursion;

import java.util.Scanner;

//pair or single choice

public class FriendsPairing {
    
    public static int waysToPair(int n){
        if (n==1 || n==2)
            return n;
        // int s = waysToPair(n-1);
        // int p = (n-1)*waysToPair(n-2);
        // return s+p;

        return waysToPair(n-1) + (n-1)*waysToPair(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people : ");
        int n =sc.nextInt();
        System.out.println("Ways : " + waysToPair(n));
        sc.close();
    }
}
