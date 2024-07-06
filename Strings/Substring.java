import java.util.Scanner;

public class Substring {

    public static String substring(String str, int start, int end){
        String substring = "";
        for(int i=start; i<end && i<str.length(); i++){     //handles out-of-range end value as well
            substring+=str.charAt(i);
        }
        return substring;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();

        System.out.print("Enter Start and End : ");
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println("Substring : " + substring(str, start, end));

        //built-in
        System.out.println("Substring : " + str.substring(start, end));

        sc.close();
    }
}
