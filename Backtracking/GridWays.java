package Backtracking;

import java.util.Scanner;

//total ways from 0,0 to n-1, m-1 with only down and right moves

public class GridWays {

    public static int totalWays(int i, int j, int n, int m){
        if(i==n-1 && j==m-1){
            return 1;
        } else if(i==n || j==m){
            return 0;
        }
        return totalWays(i+1, j, n, m) + totalWays(i, j+1, n, m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows : ");
        int n = sc.nextInt();
        System.out.print("Enter  cols : ");
        int m = sc.nextInt();
        System.out.println("Total Ways : " + totalWays(0,0,n,m));
        sc.close();
    }
}

// maths trick
/*
 total r moves = m-1
 total d moves = n-1

 therefore we just need to find their permutaions
    ans = ((n-1 + m-1)!)/((n-1)! * (m-1)!)
 */