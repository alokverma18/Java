package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class WaterProblem {

    public static int maxWaterBrute(ArrayList<Integer> heights){
        int max = 0;
        for (int i = 0; i < heights.size(); i++) {
            for (int j = i+1; j < heights.size(); j++) {
                max = Math.max(max, Math.min(heights.get(i), heights.get(j))*(j-i));
            }
        }
        return max;
    }

    public static int maxWater(ArrayList<Integer> heights){
        int l = 0;
        int r = heights.size()-1;
        int max = 0;
        while(l<r){
            max = Math.max(max, Math.min(heights.get(l), heights.get(r))*(r-l));
            if(heights.get(l)<heights.get(r)){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of walls : ");
        int n = sc.nextInt();
        ArrayList<Integer> heights = new ArrayList<>();

        System.out.print("Enter heights of each wall : ");
        for (int i = 0; i < n; i++) {
            //int v = sc.nextInt();
            heights.add(sc.nextInt());
        }
        System.out.println("Maximum Capacity : " + maxWaterBrute(heights));
        System.out.println("Maximum Capacity : " + maxWater(heights));

        sc.close();
    }
}
