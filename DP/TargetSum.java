public class TargetSum {
    
    public static boolean possible(int[] nums, int target){
        boolean dp[][] = new boolean[nums.length+1][target+1];

        // true for target=0, others already false;

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int val = nums[i-1];
                if(nums[i-1]<=j && dp[i-1][j-val]){
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[nums.length][target];
    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 3};
        int target = 10;

        System.out.println(possible(nums, target));
    }
}
