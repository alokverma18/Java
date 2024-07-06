public class LongestCommonSubstring {
    
    //WRONG

    // public static int lcs(String s1, String s2, int n, int m, int[][] dp, int ans){
    //     if(m==0 || n==0)
    //         return 0;
    //     if(dp[n][m]!=-1){
    //         return dp[n][m];
    //     }
    //     if(s1.charAt(n-1)==s2.charAt(m-1)){
    //         dp[n][m] = 1 + lcs(s1, s2, n-1, m-1, dp, ans);
    //         ans = Math.max(ans, dp[n][m]);
    //         return dp[n][m];
    //     } else {
    //         return dp[n][m] = 0;
    //     }
    // }



    //Tabulation
    public static int lcs2(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abgcde";

        // int[][] dp = new int[s1.length()+1][s2.length()+1];
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // System.out.println(lcs(s1, s2, s1.length(), s2.length(), dp, 0));


        System.out.println(lcs2(s1, s2));
    }
}
