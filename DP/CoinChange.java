//total no of ways - unbounded

public class CoinChange {

    public static int countWays(int[] coins, int sum){
        int[][] dp = new int[coins.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int coin = coins[i-1];
                if(coin<=j){
                    int include = dp[i][j-coin];
                    int exclude = dp[i-1][j];
                    dp[i][j] = include + exclude;
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;

        System.out.println(countWays(coins, sum));
    }    
}
