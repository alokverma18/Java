import java.util.*;

public class MaxSubarraySumBrute {
    public static void maxSum(int arr[]){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subSum = 0;
                for (int k = i; k <= j; k++) {
                    subSum+=arr[k];
                }
                if (subSum>max){
                    max = subSum;
                }                
            }
        }
        System.out.println("\nMax Subarray Sum: " + max);
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

