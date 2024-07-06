package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static int maxProfit(int[] profits, int[] weights, int capacity){
        
        //sorting
        double[][] items = new double[profits.length][2];
        for (int i = 0; i < items.length; i++) {
            items[i][0] = i;
            items[i][1] = (double)profits[i]/weights[i];
        }

        //sorting on the basis of column 1 - p/w
        Arrays.sort(items, Comparator.comparingDouble(o -> o[1]));

        int profit = 0;
        int i = items.length-1;

        while(capacity!=0 && i>=0){
            int item = (int)items[i][0];
            if(weights[item]<capacity){
                System.out.println("Item : " + item);
                profit+=profits[item];
                capacity-=weights[item];
            } else {
                System.out.println((double)capacity/weights[item] + " of Item " + item);
                profit+=capacity*items[i][1];
                capacity = 0;
            }
            i--;
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] profits = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        System.out.println("Max Profit : " + maxProfit(profits, weights, capacity));
    }
}
