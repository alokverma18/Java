/*
 * count mountain ranges when no of pairs of up and down strokes are given
 * at any point no. of downstrokes<=no. of upstrokes
 * 
 * Same as Catalan
 */
public class MountainRanges {
    
    public static int count(int n){
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
        int pairs = 5;
        System.out.println(count(pairs));
    }
}
