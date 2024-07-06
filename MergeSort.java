import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] nums, int l, int r){
        int temp[] = new int[r-l+1];
        int mid = l + (r-l)/2;
        int i = l, j = mid+1, k=0;

        while(i<=mid && j<=r){
            if(nums[i]<nums[j]){ 
                temp[k]=nums[i];
                i++;
                k++;
            } else {
                temp[k]=nums[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k] = nums[i];
            i++; k++;
        }
        while(j<=r){
            temp[k] = nums[j];
            j++; k++;
        }
        for(i=l, j=0; j<temp.length; i++, j++){
            nums[i] = temp[j];
        }
    }

    public static void sort(int[] nums, int l, int r){

        if(l>=r){
            return;
        }
        int mid = l + (r-l)/2;
        sort(nums, l, mid);
        sort(nums, mid+1, r);

        merge(nums, l, r);
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
