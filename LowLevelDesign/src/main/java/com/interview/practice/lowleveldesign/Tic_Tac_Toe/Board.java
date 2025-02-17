package com.interview.practice.lowleveldesign.Tic_Tac_Toe;

public class Board {

    private MarkEnumType[][] board;
    private int size;
    private int moveCount;

    public Board(int size) {
        this.board = new MarkEnumType[size][size];
        this.size = size;
        this.moveCount = 0;
    }

    public boolean addPiece(int row, int col, MarkEnumType mark) {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = mark;
        moveCount++;
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            System.out.print(" | ");
            for(int j = 0; j < size; j++) {
                if(board[i][j] != null)
                    System.out.print(board[i][j] + " | ");
                else {
                    System.out.print("   | ");
                }
            }
            System.out.println();
        }
    }

    public boolean isWinner(int row, int col) {
        return checkRows(row) || checkCols(col) || checkDiagonals(row, col);
    }

    private boolean checkDiagonals(int row, int col) {
        if(row != col && row + col != size-1) {
            return false;
        }
        return checkDiagonal1(row, col) || checkDiagonal2(row, col);
    }

    private boolean checkDiagonal2(int row, int col) {
        MarkEnumType currentDiagonalMark = board[0][size-1];

        if (currentDiagonalMark == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (board[i][size-1-i] != currentDiagonalMark) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal1(int row, int col) {
        MarkEnumType currentDiagonalMark = board[0][0];

        if (currentDiagonalMark == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (board[i][size-1-(size-1-i)] != currentDiagonalMark) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(int col) {

        MarkEnumType currentColMark = board[0][col];

        for (int i = 0; i < size; i++) {
            if (board[i][col] == null) {
                return false;
            } else if (board[i][col] != currentColMark) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRows(int row) {
        MarkEnumType currentColMark = board[row][0];
        for(int i = 0; i < size; i++) {
            if(board[row][i] == null) {
                return false;
            } else if(board[row][i] != currentColMark) {
                return false;
            }
        }
        return true;
    }

    public boolean isDraw() {
        return moveCount == size * size;
    }

    /*public boolean isDraw() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }*/
}
