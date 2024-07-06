import java.util.Scanner;

public class StaircaseSearchInMatrix {

    public static void search(int matrix[][], int key) {
        int row = 0, col = matrix.length-1;
        
        while(row<matrix.length && col>=0){
            if(matrix[row][col] == key){
                System.out.println("Found at Position : "+ row + "," + col);
                return;
            }
            else if(matrix[row][col] > key){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Not found");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Rows : ");
        int n = sc.nextInt();

        System.out.print("Enter Columns : ");
        int m = sc.nextInt();

        int matrix[][] = new int[n][m];
        System.out.print("Enter the Elements : ");
        for (int i = 0; i < n; i++) {
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter Target : ");
        int key = sc.nextInt();

        search(matrix, key);
        sc.close();
    }
}
