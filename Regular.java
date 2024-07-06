import java.util.*;

public class Regular {

    public static boolean isOperator(String token){
        String[] operators = {"+", "-", "*", "/", "%", "="};

        for (int j = 0; j < operators.length; j++) {
            if(operators[j].equals(token)){
                return true;
            }
        }
        return false;
    }

    public static boolean isKeyword(String token){
        String[] keyWords = {"auto","break","case","char","const","continue","default",
        "do","double","else","enum",
        "extern","float","for","goto",
        "if","int","long","register","return","short","signed",
        "sizeof","static","struct",
        "switch","typedef","union", "unsigned","void","volatile","while"};

        
        for (int j = 0; j < keyWords.length; j++) {
            if(keyWords[j].equals(token)){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String token){
        String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for (int i = 0; i < nums.length; i++) {
            if(token.equals(nums[i])){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String s = sc.nextLine();

        String[] tokens = s.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(isKeyword(token)){
                System.out.println(token +  " : Keyword");
            } else if(isOperator(token)){
                System.out.println(token + " : Operator");
            } else if(isNumeric(token)){
                System.out.println(token + " : Numeric");
            } else if(token.equals(";")) {
                System.out.println("; : Semi-colon Delimiter");
            } else {
                System.out.println(token + " : Identifier" );
            }
        }
    }



}
