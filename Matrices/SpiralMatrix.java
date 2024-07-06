import java.util.Scanner;

public class SpiralMatrix {
    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow<=endRow && startCol<=endCol){

            //top
            for(int j=startCol; j<=endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }

            //right
            for(int i=startRow+1; i<=endRow; i++){
                if(startCol==endCol){
                    break;
                }
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for (int j = endCol-1; j >= startCol; j--) {
                if(startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            //left
            for(int i=endRow-1; i>=startRow+1; i--){
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        
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

        printSpiral(matrix);

        sc.close();
    }
}
