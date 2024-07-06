import java.util.Scanner;

public class TrappedWater {

    public static int trapped(int height[]){

        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        rightMax[height.length-1] = height[height.length-1];
        for (int i = rightMax.length-2; i >=0 ; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trapped = 0;

        for (int i = 0; i < height.length; i++) {
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trapped;

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Bars : ");
        int n = sc.nextInt();

        int height[] = new int[n];

        System.out.print("Enter their Heights : ");
        for (int i = 0; i < height.length; i++) {
            height[i] = sc.nextInt();
        }

        System.out.println(trapped(height));

        sc.close();
    }
}
