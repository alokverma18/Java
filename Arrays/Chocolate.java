/*
Given an array of N integers where each value represents the number of chocolates in a packet. 
Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 
Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates 
given to the students is minimum. 
*/

import java.util.*;

public class Chocolate {

    public static int minimumDifference(int arr[], int m){

        // handle this case accordingly
        if(arr.length < m || m==0){
            return -1;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<=arr.length-m; i++){
            minDiff = (arr[i+m-1] - arr[i] < minDiff) ? arr[i+m-1] - arr[i] : minDiff;
        }
        return minDiff;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Packets : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter the number of Chocolates in each Packet : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the number of Children : ");
        int m = sc.nextInt();

        System.out.println("Minimum difference : " + minimumDifference(arr, m));

        sc.close();
    }
}
