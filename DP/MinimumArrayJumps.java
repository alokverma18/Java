/*
 * arr defines the possible jumps in each step if a[i] = 3, 
 * therefore you an take 1 step, 2 steps or 3 steps in one jump
 */

import java.util.Arrays;

public class MinimumArrayJumps {

    public static int minJumps(int[] jumps){

        int n = jumps.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for (int i = n-2; i >=0; i--) {
            int j = jumps[i];
            int ans = Integer.MAX_VALUE;
            for (int k = 1; k <= j; k++) {
                if(dp[i+k]!=-1)
                    ans = Math.min(ans, 1 + dp[i+k]);
            }
            if(ans!=Integer.MAX_VALUE)
                dp[i] = ans;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp[0];
    }
    public static void main(String[] args) {

        int[] jumps = {2, 3, 1, 0, 0};

        System.out.println(minJumps(jumps));
        
    }
}
