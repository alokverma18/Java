public class Knapsack01 {
    
    // O(2^n)

    public static int knapsackRecurive(int[] wt, int[] profit, int capacity, int i){
        if(capacity==0 || i==wt.length){
            return 0;
        }

        if(wt[i]<=capacity){
            int include = profit[i]+knapsackRecurive(wt, profit, capacity-wt[i], i+1);
            int exclude = knapsackRecurive(wt, profit, capacity, i+1);
            return Math.max(include, exclude);
        } else {
            return knapsackRecurive(wt, profit, capacity, i+1);
        }

    }

    // O(n*w)

    //Memoization - Recursion

    public static int knapsack(int[] wt, int[] profit, int capacity, int i, int dp[][]){
        if(capacity==0 || i==wt.length){
            return 0;
        }
        if(dp[i][capacity] != -1){
            return dp[i][capacity];
        }

        if(wt[i]<=capacity){
            int include = profit[i]+knapsack(wt, profit, capacity-wt[i], i+1, dp);
            int exclude = knapsack(wt, profit, capacity, i+1, dp);
            dp[i][capacity] = Math.max(include, exclude);
            return dp[i][capacity];
        
        } else {
            dp[i][capacity] = knapsack(wt, profit, capacity, i+1, dp);
            return dp[i][capacity];
        }
    }


    //Tabulation - Iteration

    public static int knapsack2(int[] wt, int[] profit, int capacity){

        int dp[][] = new int[wt.length+1][capacity+1];

        // first col = 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // first row = 0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int p = profit[i-1];
                int w = wt[i-1];

                if(w<=j){
                    int include = p + dp[i-1][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else{
                    dp[i][j] = dp[i-1][j];  
                }
                
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[wt.length][capacity];
    }

    public static void main(String[] args) {
        int[] wt = {2, 5, 1, 3, 4};
        int[] profit = {15, 14, 10, 45, 30};
        int capacity = 7;

        System.out.println(knapsackRecurive(wt, profit, capacity, 0));


        int dp[][] = new int[wt.length+1][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(wt, profit, capacity, 0, dp));

        System.out.println(knapsack2(wt, profit, capacity));

    }
}
