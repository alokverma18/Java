import java.util.Scanner;

public class CountSort {
    
    public static void sort(int arr[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int range = max-min+1;

        int freq[] = new int[range];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]-min] += 1;
        }

        int j = 0;

        //for Descending order
        //for (int i = freq.length-1; i >=0 ; i--) {
        
        for (int i = 0; i < freq.length; i++) {
            while(freq[i]>0){
                arr[j++] = i+min;
                freq[i]--;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of the Array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);

        System.out.print("Sorted : ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
