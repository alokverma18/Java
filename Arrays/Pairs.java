import java.util.*;

public class Pairs {

    public static void pairs(int arr[]){
        int totalPairs=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
                totalPairs++;
            }
        }
        System.out.println("\nTotal Pairs : " + totalPairs);
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

        pairs(arr);

        sc.close();
    }
}
