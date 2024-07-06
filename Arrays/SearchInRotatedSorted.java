import java.util.Scanner;

public class SearchInRotatedSorted {

    public static int search(int[] nums, int target) {
        int min = minIndex(nums);
        if(nums[min]<=target && target<=nums[nums.length-1]){
            return binarySearch(nums, min, nums.length-1, target);
        }
        else {
            return binarySearch(nums, 0, min, target);
        }   
    }
    public static int binarySearch(int nums[], int l, int r, int target){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        return -1;
    }
    public static int minIndex(int nums[]){
        int l = 0; 
        int r = nums.length-1;
        while(l<r){
            int mid = l +(r-l)/2;
            if(mid>0 && nums[mid-1]>nums[mid])
                return mid;
            else if(nums[mid]>=nums[l] && nums[mid]>nums[r])
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
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

        System.out.print("Enter Target : ");
        int target = sc.nextInt();

        System.out.println("Index (if present else -1) : " + search(arr, target));

        sc.close();
    }
}
