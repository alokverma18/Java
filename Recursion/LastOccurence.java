package Recursion;

import java.util.Scanner;

public class LastOccurence {
    
    public static int lastOccurence(int nums[], int target, int i){
        if (i==nums.length)
            return -1;
        
        int found = lastOccurence(nums, target, i+1);

        if (found == -1 && nums[i]==target)
            return i;

        return found;
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
        System.out.print("Enter element to Search : ");
        int target = sc.nextInt();
        System.out.println("Index : " + lastOccurence(nums, target, 0));
        sc.close();
    }
}
