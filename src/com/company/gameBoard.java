        package com.company;
        public class gameBoard {

            static boolean checkFull(char board[][]) {
                int k = 0;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] != '-') {
                            k++;
                        }
                    }
                }
                if (k == 42) {
                    return true;
                } else {
                    return false;
                }
            }
            static void printBoard(final char Board[][]) {
                System.out.print((char)27 + "[4m");
                System.out.println(" 1 2 3 4 5 6 7 ");

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < Board[i].length; j++) {
                        System.out.print("|" + Board[i][j]);
                        if (j == Board.length)
                            System.out.print("|");
                    }
                    System.out.println();
                }
                System.out.print((char)27 + "[0m");
            }

            static boolean checkWinVertical(char board[][], int row, int column, char currentPiece) {
                for (int i = 0; i < board.length - 3; i++) {
                    if (board[i][column] == currentPiece) {
                            if ((board[i][column] == currentPiece)
                                    && (board[i + 1][column] == currentPiece)
                                    && (board[i + 2][column] == currentPiece)
                                    && (board[i + 3][column] == currentPiece)){
                                        return true;
                            }
                    }
                }
                return false;
            }
            static boolean checkWinHorizontal(char board[][], int row, int column, char currentPiece) {
                for (int i = 0; i < board[row].length - 3; i++) {
                            if ((board[row][i] == currentPiece)
                                    && (board[row][i + 1] == currentPiece)
                                    && (board[row][i + 2] == currentPiece)
                                    && (board[row][i + 3] == currentPiece)){
                                return true;
                            }
                }
                return false;
            }
            static boolean checkWinDiagonalUp(char board[][], int row, int column, char currentPiece) {
                for (int i = 0; i < board.length - 3; i++) {
                    for (int j = 0; j < board[row].length - 3; j++) {
                        if ((board[i][j] == currentPiece)
                                && (board[i + 1][j + 1] == currentPiece)
                                && (board[i + 2][j + 2] == currentPiece)
                                && (board[i + 3][j + 3] == currentPiece)){
                                        return true;
                        }
                    }
                }
                return false;
            }
            static boolean checkWinDiagonalDown(char board[][], int row, int column, char currentPiece) {
                for (int i = board.length - 1; i > 2; i--) {
                    for (int j = 0; j < board[row].length - 3; j++) {
                        if ((board[i][j] == currentPiece)
                                &&(board[i - 1][j + 1] == currentPiece)
                                &&(board[i - 2][j + 2] == currentPiece)
                                &&(board[i - 3][j + 3] == currentPiece)){

                                        return true;
                        }
                    }
                }
                return false;
            }

        }
