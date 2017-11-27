package com.company;
import java.util.*;

@SuppressWarnings("resource")

public class ProjectMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Connect 4");
        /*System.out.println((char)27 + "[4m" +
                "│ E │ E │ E │ E │ E │ E │ E │\n" +
                "│  │ _ │ _ │ _ │ _ │ _ │ _ │\n" +
                "│ ● │ ● │ ● │ ● │ ● │ ● │ ● │\n" +
                "│ W │ ⚪ │ _ │ _ │ _ │ _ │ _ │\n" +
                "│ Q │ ⚪ │ ⚪ │ ⚪ │ _ │ _ │ _ │\n" +
                "│ ⚫ │ ⚫ │ ⚫ │ ⚫ │ ⚪ │ ⚪ │ ⚪ │\n");
        System.out.println((char)27 + "[0m");
        */System.out.println(/*(char)27 + "[0m" + */"Menu");
        System.out.println("1 - Play Connect Four");
        System.out.println("2 - Quit Connect Four");
        System.out.println();
        System.out.println("Please enter an option: ");

        int userOption = input.nextInt();

        while (!(userOption == 0)) {

            switch (userOption) {

                case 1:

                    char board[][] = new char[6][7];
                    //fill board with empty spaces and output the board.
                    for (char[] row : board) {
                        Arrays.fill(row, '-');
                    }
                    System.out.println("CONNECT FOUR\n");
                    /*for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                            System.out.print(board[i][j] + " ");
                        }
                        System.out.println();
                    }


                    System.out.println("_____________\n1 2 3 4 5 6 7");
                    System.out.println("   Columns   \n");
                    */
                    System.out.println("Player 1, enter your name: ");
                    com.company.Player player1 = new com.company.Player(input.next(), 'X');
                    System.out.println("Player 2, enter your name: ");
                    com.company.Player player2 = new com.company.Player(input.next(), 'O');

                    System.out.println((char)27 + "[4m" + "Info:");
                    System.out.println("\n" + player1.getName() + " is " + player1.getPlayerPiece());
                    System.out.println(player2.getName() + " is " + player2.getPlayerPiece());
                    System.out.println("First player who gets four in a row (up/down/diagonally) wins.\n");

                    System.out.println((char)27 + "[0m");
                    gameBoard.printBoard(board);

                    boolean win = false;
                    char currentPiece = player2.getPlayerPiece();
                    int column = 0;
                    int row = 0;
                    int i = 0;
                    long start = com.company.gameTime.setCurrentTime();

                    do {
                        if (currentPiece == player2.getPlayerPiece()) {
                            currentPiece = player1.getPlayerPiece();
                        } else if (currentPiece == player1.getPlayerPiece()) {
                            currentPiece = player2.getPlayerPiece();
                        }

                        if (currentPiece == player1.getPlayerPiece()) {
                            System.out.println(player1.getName() + ": Place your piece in a column.");
                        } else if (currentPiece == player2.getPlayerPiece()) {
                            System.out.println(player2.getName() + ": Place your piece in a column.");
                        }
                        column = input.nextInt() - 1;
                        System.out.println("\n");


                        while ((column > 6 || column < 0) || (board[0][column] == 'X' || board[0][column] == 'O')) {
                            System.out.println("Invalid entry. Try again.");

                            if (currentPiece == player1.getPlayerPiece()) {
                                System.out.println(player1.getName() + ": Place your piece in a column.");
                            } else if (currentPiece == player2.getPlayerPiece()) {
                                System.out.println(player2.getName() + ": Place your piece in a column.");
                            }
                            column = input.nextInt() - 1;
                            System.out.println("\n");
                        }

                        for (i = 0; i <= 5; i++) {
                            if (board[i][column] == '-') {
                                row = i;
                            } else {
                                continue;
                            }
                        }
                        board[row][column] = currentPiece;

                        gameBoard.printBoard(board);

                        if (gameBoard.winCheck_UpDn(board, row, column, currentPiece) == true) {
                            win = true;
                        } else if (gameBoard.winCheck_LR(board, row, column, currentPiece) == true) {
                            win = true;
                        } else if (gameBoard.winCheck_DiagLRDn(board, row, column, currentPiece) == true) {
                            win = true;
                        } else if (gameBoard.winCheck_DiagLRUp(board, row, column, currentPiece) == true) {
                            win = true;
                        }

                        if (gameBoard.checkFull(board) == true) {
                            win = true;
                        }

                    } while (win == false);

                    System.out.println("GAME OVER");
                    if (gameBoard.checkFull(board) == true) {
                        System.out.println("The board is full.\nThe game is a draw.");
                    } else if (currentPiece == player1.getPlayerPiece()) {
                        System.out.println(player1.getName() + " WINS!\nCongratulations!");
                    } else if (currentPiece == player2.getPlayerPiece()) {
                        System.out.println(player2.getName() + " WINS!\nCongratulations!");
                    }

                    long end = com.company.gameTime.setCurrentTime();
                    com.company.gameTime.totalTime(end, start);
                    com.company.gameTime.getCurrentTime(end);

                    System.out.println("1 - Play Again");
                    System.out.println("2 - Quit Connect Four");
                    userOption = input.nextInt();
                    break;

                case 2:
                    System.out.println("Thank you for playing!");
                    userOption = 0;
                    break;
                default:
                    System.out.println("Invalid Option: Ending Program");
                    userOption = 0;
                    break;
            }
        }
    }
}
