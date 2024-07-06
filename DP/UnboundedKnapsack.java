public class UnboundedKnapsack {
    
    public static int knapsack(int[] wt, int[] profit, int capacity){

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
                    int include = p + dp[i][j-w];             // only a single change here from 0-1 knapsack
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

        System.out.println(knapsack(wt, profit, capacity));
    }
}
