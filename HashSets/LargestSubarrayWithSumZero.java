package HashSets;

import java.util.HashMap;

public class LargestSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0, sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(hm.containsKey(sum)){
                ans = Math.max(ans, i-hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        System.out.println(ans);
    }
}
