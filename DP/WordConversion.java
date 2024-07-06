//Minimum operations to convert s1 to s2 - add, update, delete

public class WordConversion {

    public static int minOperations(String s1, String s2, int n, int m, int[][] dp){
        if(n==0){
            return m;
        } else if(m==0) {
            return n;
        }
        
        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = minOperations(s1, s2, n-1, m-1, dp);
        } else {
            int add = 1 + minOperations(s1, s2, n, m-1, dp);
            int delete = 1 + minOperations(s1, s2, n-1, m, dp);
            int update = 1 + minOperations(s1, s2, n-1, m-1, dp);
            return dp[n][m] = Math.min(add, Math.min(delete, update));
        }
    }

    public static int minOps(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0){
                    dp[i][j] = j;
                } else if (j==0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int update = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(add, Math.min(delete, update));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        
        String s1 = "abc";
        String s2 = "sbd";

        System.out.println(minOps(s1, s2));

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
    
        System.out.println(minOperations(s1, s2, s1.length(), s2.length(), dp));
    }
}
