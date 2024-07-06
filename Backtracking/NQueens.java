package Backtracking;

import java.util.Scanner;

public class NQueens {

    public static void printBoard(char[][] board){
        System.out.println("---Board---");
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isSafe(char[][] board, int row, int col){
        //vertically up
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diagonally right
        for(int i=row-1, j = col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diagonally left
        for(int i=row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    static int sol = 0;
    
    public static void nQueens(char[][] board, int row){
        if(row==board.length){
            System.out.println("Solution " + ++sol);
            printBoard(board);
            return;
        }
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        char board[][] = new char[n][n];
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
        sc.close();
    }
}



/*
    //for printing just one solution
    
    public static boolean nQueens(char[][] board, int row){
        if(row==board.length){
            System.out.println("Solution " + ++sol);
            printBoard(board);
            return true;
        }
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueens(board, row+1)){
                    return true;
                }
                board[row][j] = 'x';
            }
        }
        return false;
    }
 */


