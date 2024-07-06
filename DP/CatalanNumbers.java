public class CatalanNumbers {
    
    public static int catalanRecursive(int n){
        if(n==0 || n==1)
            return 1;
        int cat = 0;
        for (int i = 0; i < n; i++) {
            cat+=catalanRecursive(i)*catalanRecursive(n-i-1);
        }
        return cat;
    }

    public static int catalanMemo(int n, int[] dp){
        if(n==0 || n==1)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        else{
            int cat = 0;
            for (int i = 0; i < n; i++) {
                cat+=catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
            }
            return dp[n] = cat;
        }
    }

    //tabulation
    public static int catalan(int n){
        if(n==0 || n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {

        int n = 10;

        System.out.println(catalanRecursive(n));

        System.out.println(catalanMemo(n, new int[n+1]));
        
        System.out.println(catalan(n));
    }
}
