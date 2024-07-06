import java.util.*;

public class Calculator {
    public static void main(String[] args){

        // Input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        double a = sc.nextDouble();

        System.out.print("Enter another number : ");
        double b = sc.nextDouble();

        System.out.print("Enter an operator (+, -, *, /, %) : ");
        String op = sc.next();

        sc.close();     //not necessary

        double result;

        // if (op.equals("+"))
        //     result = a+b;
        // else if (op.equals("-"))
        //     result = a-b;
        // else if (op.equals("*"))
        //     result = a*b;
        // else if (op.equals("/"))
        //     result = a/b;
        // else if (op.equals("%"))
        //     result = a%b;
        // else
        //     result = 0;     // it's not right but still    


        switch(op){
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
                break;
            case "%":
                result = a%b;
                break;
            default:
                result = 0;
        }

        System.out.println("Result : " + result);
    }
}
