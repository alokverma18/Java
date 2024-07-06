import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixChainMultiplication {
    
    public static int mcmRecursive(int[] arr, int i, int j){
        if(i==j)
            return 0;
        
        int minCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost1 = mcmRecursive(arr, i, k);
            int cost2 = mcmRecursive(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            minCost = Math.min(minCost, cost1 + cost2 + cost3);
        }
        return minCost;
    }

    public static int mcmMemo(int[] arr, int i, int j, int[][] dp){
        if(i==j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcmRecursive(arr, i, k);
            int cost2 = mcmRecursive(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            minCost = Math.min(minCost, cost1 + cost2 + cost3);
        }
        return dp[i][j] = minCost;
    }

    public static int mcm(int[] arr){
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n-len+1; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        return dp[1][arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(mcmRecursive(arr, 1, arr.length-1));

        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcmMemo(arr, 1, arr.length-1, dp));


        System.out.println(mcm(arr));
    }
}
