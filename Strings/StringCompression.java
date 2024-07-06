import java.util.Scanner;

public class StringCompression {

    public static String compressString(String str){

        StringBuilder sb = new StringBuilder("");

        sb.append(str.charAt(0));
        int n =str.length();
        int count = 1;
        for(int i=1; i<n; i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
                if(i==n-1){
                    sb.append(count);
                }
            } else {
                if (count > 1){
                    sb.append(count);
                }
                sb.append(str.charAt(i));
                count = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String to compress : ");
        String s = sc.nextLine();
        System.out.println(compressString(s));
        sc.close();
    }
}
