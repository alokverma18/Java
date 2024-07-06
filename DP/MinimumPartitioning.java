/*
 * Calculate min difference b/w any two partitions
 */

public class MinimumPartitioning {

    public static int minDiff(int[] arr){
        int sum = 0;
        for (int x : arr) {
            sum+=x;
        }
        int w = sum/2;
        int dp[][] = new int[arr.length+1][w+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int item = arr[i-1];
                if(item<=j){
                    int include = arr[i-1] + dp[i-1][j-item];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[arr.length][w];
        int sum2 = sum - sum1;
        return Math.abs(sum2-sum1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 15};
        System.out.println(minDiff(arr));
    }
}
