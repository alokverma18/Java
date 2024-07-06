package Recursion;
import java.util.Scanner;

public class SortedArray {
    
    public static boolean sortedArray(int[] nums, int i){
        if (i == nums.length-1){
            return true;
        }
        if(nums[i]>nums[i+1]){
            return false;
        }
        return sortedArray(nums, i+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of Array : ");
        int n =  sc.nextInt();
        int nums[] = new int[n];
        System.out.print("Enter Elements : ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Sorted : " + sortedArray(nums, 0));
        sc.close();
    }
}
