//Max selling price of rod when sold in pieces

public class RodCutting {

    public static int maxPrice(int[] lengths, int[] prices, int rodLength){
        int[][] dp = new int[prices.length+1][rodLength+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        // anyways it was already 0 

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int len = lengths[i-1];
                int price = prices[i-1];
                if(len<=j){
                    int include = price + dp[i][j-len];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[prices.length][rodLength];
    }
    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;

        //2+6 = 5+17
        System.out.println("Max Selling Price : " + maxPrice(lengths, prices, rodLength));
    }
}
