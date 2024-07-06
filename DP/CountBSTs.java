//no. of different BSTs possible with given nodes, (depende on the no of nodes, not the values)
// equal to Catalan 

public class CountBSTs {

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
        int n = 5;
        // or int[] arr = {1, 2, 3, 4, 5,0};

        System.out.println(count(n));
    }
}
