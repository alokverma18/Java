import java.util.*;

public class SubArrays {
    public static void subarrays(int arr[]){
        int totalSubarrays=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print(" [");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]+" ");
                }
                totalSubarrays++;
                System.out.print("], ");
                
            }
        }
        System.out.println("\nTotal Subarrays : " + totalSubarrays);
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

        subarrays(arr);

        sc.close();
    }
    
}
