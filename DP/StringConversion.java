/*min ops to convert s1 to s2 with only delete and insert ops
    approach 1 : WordConversion code
    approach 2 :
    find lcs : common
    ans = (s1-lcs) + (s2-lcs)
*/
public class StringConversion {
    
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

    public static int minOperations(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), dp); 
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "aceg";
    
        System.out.println(minOperations(s1, s2));
    }
}
