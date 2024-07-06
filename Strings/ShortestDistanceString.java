import java.util.*;

public class ShortestDistanceString {

    public static double minDistance(String path){
        
        int x = 0, y = 0;
        for(int i=0; i<path.length(); i++){
            switch(path.charAt(i)){
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                default:
                    continue;
            }
        }
        return  Math.sqrt(x*x + y*y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String path = sc.next();

        System.out.println("Shortest Distance is : " + minDistance(path));
        sc.close();
    }
}