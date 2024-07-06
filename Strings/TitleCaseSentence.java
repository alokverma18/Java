import java.util.*;
public class TitleCaseSentence {

    public static String titleCase(String str){
        StringBuilder sb = new StringBuilder("");

        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1; i<str.length(); i++){
            if (str.charAt(i-1) == ' '){
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Sentence : ");
        String str = sc.nextLine();
        System.out.println("Title Case : " + titleCase(str));
        sc.close();
    
    }
}
