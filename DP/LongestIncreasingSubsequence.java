import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    
    public static int lis(int[] nums){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) 
            set.add(i);

        int arr[] = new int[set.size()];

        int k = 0;
        for (int x : set)
            arr[k++] = x; 

        int dp[][] = new int[nums.length+1][arr.length+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(nums[i-1]==arr[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[nums.length][arr.length];
    }
    public static void main(String[] args) {
        int nums[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(nums));
    }
}
