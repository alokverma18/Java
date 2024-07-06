import java.util.Scanner;

public class LexicographicallyLargest {

    public static String lexLarge(String arr[]){
        String largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (largest.compareToIgnoreCase(arr[i]) < 0){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static String myLexLarge(String arr[]){
        String largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            String str = arr[i];
            int end = Math.min(largest.length(), str.length());
            for(int j=0; j<end; j++){
                if(str.charAt(j)>largest.charAt(j)){
                    largest = str;
                    break;
                } else if (str.charAt(j)<largest.charAt(j)){
                    break;
                }
                if(j==end-1){
                    largest = (largest.length()>str.length()) ? largest : str;
                }
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Strings : ");
        int n = sc.nextInt();

        String arr[] = new String[n];

        System.out.print("Enter the Strings : ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        System.out.println("Lexicographically Largest String : " + lexLarge(arr));

        System.out.println("Lexicographically Largest String : " + myLexLarge(arr));

        sc.close();
    }
}
