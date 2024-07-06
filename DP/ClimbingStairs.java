public class ClimbingStairs {
    
    //memoization
    public static int numOfWays(int n, int dp[]){
        if(n<0){
            return 0;
        } else if(n==0){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = numOfWays(n-1, dp) + numOfWays(n-2, dp);
        return dp[n];
        
    }

    //tabulation
    public static int countWays(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        
        int n = 7;
        System.out.println(numOfWays(n, new int[n+1]));

        System.out.println(countWays(n));
    }
}
