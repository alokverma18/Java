package Stack;

import java.util.Stack;

public class NextGreater {

    public static int[] nextGreater(int[] nums){
        int[] next = new int[nums.length];
        int n = nums.length-1;
        next[n] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(nums[n]);
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && nums[i]>=s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                next[i] = -1;
            } else {
                next[i] = s.peek();
            }
            s.push(nums[i]);
        }

        return next;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {6, 8, 0, 1, 3};
        
        int[] next = nextGreater(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
    }
}
