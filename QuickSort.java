import java.util.Scanner;

public class QuickSort {

    public static int partition(int[] nums, int l, int r){
        int pivotElement = nums[r];

        int i=l-1, j;

        for(j=l; j<r; j++){
            if(nums[j]<=pivotElement){
                int t = nums[++i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        int t = nums[++i];
        nums[i] = nums[j];
        nums[j] = t;
        return i;
    }

    public static void sort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int p = partition(nums, l, r);
        sort(nums, l, p-1);
        sort(nums, p+1, r);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of the Array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, 0, arr.length-1);

        System.out.print("Sorted : ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
