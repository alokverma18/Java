import java.util.*;

public class MaxSubarraySumKadane {

    public static void maxSum(int arr[]){
        //All Negative Case
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxSum = (arr[i]>maxSum) ? arr[i] : maxSum;
        }
        if(maxSum<0){
            System.out.println("\nMax Subarray Sum: " + maxSum);
            return;
        }
        //general cases

        maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            curSum = (curSum + arr[i] < 0) ? 0 : curSum + arr[i];
            maxSum =  (curSum>maxSum) ? curSum : maxSum;
        }
        System.out.println("\nMax Subarray Sum: " + maxSum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Length of Array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter the Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        maxSum(arr);

        sc.close();
    }
    
}

