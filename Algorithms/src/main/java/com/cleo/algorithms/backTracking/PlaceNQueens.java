package com.cleo.algorithms.backTracking;

// TODO: 06/09/23 "Check the set Zero Placement"
public class PlaceNQueens {
    public static void placeNQueens(int n){

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][] board = new int[n][n];
        placeQueens(board,0,n);


    }
    public static boolean isSafe(int[][] board,int row, int column,int N){
        if(row<0||row>=N||column<0||column>=N)
            return false;
        for (int i = 0; i < N; i++) {
            if(board[row][i]==1)
                return false;
            if(board[i][column]==1)
                return false;

        }
        for (int i = row; i >0; i--) {
            if(board[i-1][i-1]==1)
                return false;
        }
        for (int i = column; i >0 ; i--) {
            if(board[i-1][i-1]==1)
                return false;
        }
        for (int i = row; i < N-1; i++) {
            if(board[i+1][i+1]==1)
                return false;
        }
        for (int i = column; i < N-1; i++) {
            if(board[i+1][i+1]==1)
                return false;
        }
        return true;

    }

    public static void placeQueens(int[][] board,int row, int N){
        if(row==N){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j]+" ");
                }
            }

            System.out.println();
            //board[N-1][N-1]=0;
            return;
        }
        for (int column = 0; column < N; column++) {
            if(isSafe(board,row,column,N)) {
                board[row][column] = 1;

                placeQueens(board,row+1,N);


            }else{
                if(row>0)
                    placeQueens(board,row-1,N);
            }
            board[row][column]=0;


        }



    }

    public static void main(String[] args) {
        placeNQueens(3);
    }
}
