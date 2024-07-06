package Recursion;

//number of ways to tile 2xn area using 2x1 tiles - vertically or horizontally
// is it fibonacci series ? 🤔
import java.util.Scanner;

public class TilingProblem {

    public static int waysToTile(int n){
        if (n==1 || n==0){
            return 1;
        }
        int h = waysToTile(n-2);
        int v = waysToTile(n-1);
        return h+v;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.println("No. of Ways : " + waysToTile(n));
        sc.close();
    }
}
