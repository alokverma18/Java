/*
    ? - one char
    * - any no of chars
*/
public class WildcardMatching {

    public static boolean matchesPattern(String s, String pattern){
        boolean[][] dp = new boolean[s.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if(pattern.charAt(j-1)=='*')
                dp[0][j] = dp[0][j-1];
        }

        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][pattern.length()];
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String pattern = "*****?**b**?*c*";

        System.out.println(matchesPattern(s, pattern));
    }
}
