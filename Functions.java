import java.util.*;

public class Functions {
    
    public static double calculator(double x, double y, String op){
        double result;

        switch(op){
            case "+":
                result = x+y;
                break;
            case "-":
                result = x-y;
                break;
            case "*":
                result = x*y;
                break;
            case "/":
                result = x/y;
                break;
            case "%":
                result = x%y;
                break;
            default:
                result = 0;         //not correct logically but still
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        double x = sc.nextDouble();

        System.out.print("Enter another Number : ");
        double y = sc.nextDouble();

        System.out.print("Enter an Operator (+, -, *, /, %) : ");
        String op = sc.next();

        System.out.println("Result of " + x + op + y + " : " + calculator(x, y, op));


        sc.close();
    }
}
