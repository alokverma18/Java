package Recursion;

import java.util.Scanner;

public class Exponent {

    public static double exponent(double b, int e){
        if (e==0){
            return 1;
        }
        return b*exponent(b, e-1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base : ");
        double b = sc.nextDouble();
        System.out.print("Enter exponent : ");
        int e = sc.nextInt();
        System.out.println("Answer : " + exponent(b, e));
        sc.close();
    }
}
