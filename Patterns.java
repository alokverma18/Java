import java.util.*;

public class Patterns {
    public static void main(String[] args){
        System.out.print("Enter number of Rows : ");

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        

        System.out.println("Half Pyramid");
        for(int i=0; i<rows; ++i){
            for(int j=0; j<i+1; ++j){
                System.out.print("*");
            }
            System.out.println();
        }

        // //using while loop

        // int i=0;
        // while(i<rows){
        //     int j=0;
        //     while(j<i+1){
        //         System.out.print("*");
        //         j++;
        //     }
        //     System.out.println();
        //     i++;
        // }

        // //Using do-while loop

        // i=0;
        // do{
        //     int j = 0;
        //     do{
        //         System.out.print("*");
        //         j++;
        //     } while(j<i+1);
        //     i++;
        //     System.out.println();
        // } while (i<rows);
        
        System.out.println("Inverted Half Pyramid");
        for (int i = 0; i < rows; i++) {
            for(int j=0; j<rows-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Right Half Pyramid");
        for (int i = 0; i < rows; i++) {
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Inverted Right Half Pyramid");
        for (int i = 0; i < rows; i++) {
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<rows-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pyramid");
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<(2*i)+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Diamond");
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<(2*i)+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<(2*(rows-i-1))+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Hollow Rectangle");

        System.out.print("Rows : ");
        rows = sc.nextInt();
        System.out.print("Columns : ");
        int columns = sc.nextInt();

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(i==0 || i==rows-1 || j==0 || j == columns-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("Number Patterns : ");

        for(int i=0; i<rows; i++){
            for(int j=0; j<i+1; j++){
                System.out.print(j+1 + " ");
            }
            System.out.println();  
        }

        int s = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<i+1; j++){
                System.out.print(++s + " ");
            }
            System.out.println();  
        }
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<i+1; j++){
                System.out.print((j+i+1)%2 + " ");
            }
            System.out.println();  
        }

        System.out.println("Butterflyyy");
        for(int i=0; i<rows; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("* ");
            }
            for(int j=0; j<(2*(rows-i-1)); j++){
                System.out.print("  ");
            } 
            for(int j=0; j<i+1; j++){
                System.out.print("* ");                
            }
            System.out.println();
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i; j++){
                System.out.print("* ");
            }
            for(int j=0; j<2*i; j++){
                System.out.print("  ");
            }
            for(int j=0; j<rows-i; j++){
                System.out.print("* ");                
            }
            System.out.println();
        }


        System.out.println("Rhombus");
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<rows; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Hollow Rhombus");
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<rows; j++){
                if(i==0 || j==0 || i==rows-1 || j==rows-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("Number Full Pyramid ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1; j++){
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }

        System.out.println("Number Pallindrome ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++){
                System.out.print(" ");
            }
            for(int j=i+1; j>0; j--){
                System.out.print(j);
            }
            for(int j=2; j<i+2; j++){
                System.out.print(j);
            } 
            System.out.println();
        }


        sc.close();

    }
}
