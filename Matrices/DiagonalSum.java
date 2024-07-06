import java.util.Scanner;

public class DiagonalSum {

    public static int sum(int matrix[][]){
        int sum = 0;

        for(int i=0; i<matrix.length; i++){
            sum+=matrix[i][i];
            if(i!=matrix.length-i-1){
                sum+=matrix[i][matrix.length-i-1];
            }
        }

        return sum;

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

        System.out.println("Diagonals Sum : " + sum(matrix));

        sc.close();
    }
}
