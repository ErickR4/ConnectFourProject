        package com.company;
        public class gameBoard {

            static boolean checkWinVertical(char _board[][], int _row, int _column, char _currentPiece) {
                for (int i = 0; i < _board.length - 3; i++) {
                    if (_board[i][_column] == _currentPiece) {

                            if ((_board[i][_column] == _currentPiece)
                                    && (_board[i + 1][_column] == _currentPiece)
                                    && (_board[i + 2][_column] == _currentPiece)
                                    && (_board[i + 3][_column] == _currentPiece)){
                                        return true;
                            }

                    }
                }
                return false;
            }
            static boolean checkWinHorizontal(char _board[][], int _row, int _column, char _currentPiece) {
                for (int i = 0; i < _board[_row].length - 3; i++) {
                            if ((_board[_row][i] == _currentPiece)
                                    && (_board[_row][i + 1] == _currentPiece)
                                    && (_board[_row][i + 2] == _currentPiece)
                                    && (_board[_row][i + 3] == _currentPiece)){
                                return true;
                            }
                }
                return false;
            }
            static boolean checkWinDiagonalUp(char _board[][], int _row, int _column, char _currentPiece) {
                for (int i = 0; i < _board.length - 3; i++) {
                    for (int j = 0; j < _board[_row].length - 3; j++) {
                        if ((_board[i][j] == _currentPiece)
                                && (_board[i + 1][j + 1] == _currentPiece)
                                && (_board[i + 2][j + 2] == _currentPiece)
                                && (_board[i + 3][j + 3] == _currentPiece)){
                                        return true;
                        }
                    }
                }
                return false;
            }
            static boolean winCheckDiagonalDown(char _board[][], int _row, int _column, char _currentPiece) {
                for (int i = _board.length - 1; i > 2; i--) {
                    for (int j = 0; j < _board[_row].length - 3; j++) {
                        if ((_board[i][j] == _currentPiece)
                                &&(_board[i - 1][j + 1] == _currentPiece)
                                &&(_board[i - 2][j + 2] == _currentPiece)
                                &&(_board[i - 3][j + 3] == _currentPiece)){

                                        return true;
                        }
                    }
                }
                return false;
            }
            static boolean checkFull(char _board[][]) {
                int k = 0;
                for (int i = 0; i < _board.length; i++) {
                    for (int j = 0; j < _board[i].length; j++) {
                        if (_board[i][j] != '-') {
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
            static void printBoard(final char tempBoard[][]) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < tempBoard[i].length; j++) {
                        System.out.print(tempBoard[i][j] + " ");
                    }
                    System.out.println();
                }


                System.out.println("_____________\n1 2 3 4 5 6 7");
                System.out.println("   Columns   \n");
            }
        }
