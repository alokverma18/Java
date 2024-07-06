import java.util.*;

public class MaxSubarraySumPrefix {
    public static void maxSum(int arr[]){

        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subSum = (i==0) ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
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

