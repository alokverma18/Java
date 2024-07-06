package Greedy;

import java.util.*;
public class MinAbsoluteSum {
    public static void main(String[] args) {
         int[] nums1 = {1, 4, 8, 7};
         int[] nums2 = {2, 6, 3, 5};

         Arrays.sort(nums1);
         Arrays.sort(nums2);

         int sum = 0;

         for (int i = 0; i < nums2.length; i++) {
            sum+=Math.abs(nums1[i]-nums2[i]);
         }

         System.out.println("Minimum Absolute Difference : " + sum);
    }
}
