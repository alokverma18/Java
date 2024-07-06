package Backtracking;

public class SudokuSolver {

    public static void printSudoku(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++) {
            if(i%3==0){
                System.out.println("____________________");
            }
            for(int j=0; j<sudoku.length; j++){
                if(j%3==0){
                    System.out.print("|");
                }
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSolved(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++) {
            for(int j=0; j<sudoku.length; j++){
                if(sudoku[i][j]==0)
                    return false;
            }
        }
        return true;
    }
    public static boolean possible(int[][] sudoku, int row, int col, int value){
        for(int i=0; i<sudoku.length; i++){
            if(sudoku[row][i] == value || sudoku[i][col] == value){
                return false;
            }
        }

        // same grid
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i=0; i<3; i++){
            for (int j = 0; j < 3; j++) {
                if(sudoku[startRow+i][startCol+j]==value){
                    return false;
                }   
            }
        }
        return true;
    }

    public static boolean solve(int[][] sudoku, int row, int col){
        if(isSolved(sudoku)){
            printSudoku(sudoku);
            return true;
        }
        int nextRow = row, nextCol = col+1;
        if(col+1 >= 9){
            nextRow+=1;
            nextCol = 0;
        }
        if(sudoku[row][col]!=0){
            return solve(sudoku, nextRow, nextCol);
        }
        for(int digit=1; digit<=9; digit++){
            if(possible(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(solve(sudoku, nextRow, nextCol)){
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] sudoku = {
            {0,0,6,0,9,0,2,0,0},
            {0,0,0,7,0,2,0,0,0},
            {0,9,0,5,0,8,0,7,0},
            {9,0,0,0,3,0,0,0,6},
            {7,5,0,0,0,0,0,1,9},
            {1,0,0,0,4,0,0,0,5},
            {0,1,0,3,0,9,0,8,0},
            {0,0,0,2,0,1,0,0,0},
            {0,0,9,0,8,0,1,0,0}
        };
        System.out.println("Unsolved : ");
        printSudoku(sudoku);
        System.out.println("\n Solved : ");
        solve(sudoku,0,0);
    }
}
