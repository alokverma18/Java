package Stack;

import java.util.Stack;

public class MaxAreaHistogram {

    public static int maxArea(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        int[] nextSmallerLeft = new int[n];
        int[] nextSmallerRight = new int[n];

        Stack<Integer> s = new Stack<>();
       
        for(int i=0; i<n; i++){
            int curHeight = heights[i];
            while(!s.isEmpty() && curHeight<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();

        for(int i=n-1; i>=0; i--){
            int curHeight = heights[i];
            while(!s.isEmpty() && curHeight<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmallerRight[i] = n;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, heights[i]*(nextSmallerRight[i]-nextSmallerLeft[i]-1));
        }

        return maxArea;

    }
    public static void main(String[] args) {
        int[] heights = new int[] {2, 4};
        System.out.println("Max area : " + maxArea(heights));
    }
}
