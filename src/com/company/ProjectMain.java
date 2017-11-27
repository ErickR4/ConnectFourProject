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
        System.out.println("Please input an option: ");

        int userOption = input.nextInt();

        while (!(userOption == 0)) {

            switch (userOption) {

                case 1:

                    char board[][] = new char[6][7];
                    //fill board with empty spaces and output the board.
                    for (char[] row : board) {
                        Arrays.fill(row, '-');
                    }

                    System.out.println("CONNECT FOUR");
                    System.out.println("Enter name for Player 1: ");
                    Player player1 = new Player(input.next(), 'X');
                    System.out.println("Enter name for Player 2: ");
                    Player player2 = new Player(input.next(), 'O');

                    System.out.print((char)27 + "[4m" + "Info:");
                    System.out.println("\n" + player1.getName() + " is " + player1.getPlayerPiece());
                    System.out.println(player2.getName() + " is " + player2.getPlayerPiece());
                    System.out.println("First player who get four pieces Vertically or Horizontally or diagonally wins!");

                    System.out.print((char)27 + "[0m");
                    gameBoard.printBoard(board);

                    boolean win = false;
                    char currentPiece = player2.getPlayerPiece();
                    int column;
                    int row = 0;
                    int i;
                    long start = gameTime.setCurrentTime();

                    do {
                        //switch if to play
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

                            if (currentPiece == player1.getPlayerPiece())
                                System.out.println(player1.getName() + ": Place your piece in a column.");

                            else if (currentPiece == player2.getPlayerPiece())
                                System.out.println(player2.getName() + ": Place your piece in a column.");

                            column = input.nextInt() - 1;

                        }

                        for (i = 0; i <= 5; i++) {
                            if (board[i][column] == '-')
                                row = i;
                                else
                                break;
                        }
                        board[row][column] = currentPiece;

                        gameBoard.printBoard(board);

                        if (gameBoard.checkWinVertical(board, row, column, currentPiece)) {
                            win = true;
                        } else if (gameBoard.checkWinHorizontal(board, row, column, currentPiece)) {
                            win = true;
                        } else if (gameBoard.checkWinDiagonalUp(board, row, column, currentPiece)) {
                            win = true;
                        } else if (gameBoard.winCheckDiagonalDown(board, row, column, currentPiece)) {
                            win = true;
                        }

                        if (gameBoard.checkFull(board)) {
                            win = true;
                        }

                    } while (!win);

                    System.out.println("GAME OVER");
                    if (gameBoard.checkFull(board)) {
                        System.out.println("The board is full.\nThe game is a draw.");
                    } else if (currentPiece == player1.getPlayerPiece()) {
                        System.out.println(player1.getName() + " WINS!\nCongratulations!");
                    } else if (currentPiece == player2.getPlayerPiece()) {
                        System.out.println(player2.getName() + " WINS!\nCongratulations!");
                    }

                    long end = gameTime.setCurrentTime();
                    gameTime.totalTime(end, start);
                    gameTime.getCurrentTime(end);

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
