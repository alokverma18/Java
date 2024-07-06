//longest common subsequence

public class LCS {
    
    // O(2^n)
    public static int lcsRecursive(String s1, String s2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return 1 + lcsRecursive(s1, s2, n-1, m-1);
        } else {
            int a = lcsRecursive(s1, s2, n-1, m);
            int b = lcsRecursive(s1, s2, n, m-1);
            return Math.max(a, b);
        }
    }

    //DP - Memoization - O(m*n)
    public static int lcs(String s1, String s2, int n, int m, int[][] dp){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = 1 + lcs(s1, s2, n-1, m-1, dp);
        } else {
            int a = lcs(s1, s2, n, m-1, dp);
            int b = lcs(s1, s2, n-1, m, dp);
            return dp[n][m] = Math.max(a, b);
        }
    }

    //DP - Tabulation - O(m*n)
    public static int lcs2(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "rohitsharma";
        String s2 = "viratkohli";

        System.out.println(lcsRecursive(s1, s2, s1.length(), s2.length()));


        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1; 
            }
        }
        System.out.println(lcs(s1, s2, s1.length(), s2.length(), dp));

        System.out.println(lcs2(s1, s2));
    }
}
