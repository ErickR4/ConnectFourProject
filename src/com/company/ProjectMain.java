package com.company;
import java.util.*;

public class ProjectMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to Connect 4!");
        System.out.println("Menu");
        System.out.println("1 - Play Connect Four");
        System.out.println("2 - Quit Connect Four");
        System.out.println();
        System.out.println("Please input an option: ");

        int userOption = input.nextInt();

        while (!(userOption == 0)) {
            long start = gameStats.setCurrentTime();

            switch (userOption) {

                case 1:
                    System.out.println("CONNECT FOUR");
                    System.out.println("Enter name for Player 1: ");
                    Player player1 = new Player(input.next(), 'X');
                    System.out.println("Enter name for Player 2: ");
                    Player player2 = new Player(input.next(), 'O');

                    System.out.print((char)27 + "[1m" + "Players:");
                    System.out.println("\n" + player1.getName() + " will use " + player1.getPlayerPiece());
                    System.out.println(player2.getName() + " will use " + player2.getPlayerPiece());
                    System.out.println("How To Win:");
                    System.out.println("First player who get four pieces Vertically or Horizontally or Diagonally wins!");
                    System.out.print((char)27 + "[0m");


                    char board[][] = new char[6][7]; //create board

                    //fill board with empty spaces
                    for (char[] row : board) {
                        Arrays.fill(row, '-');
                    }

                    gameBoard.printBoard(board);

                    boolean win = false; //condition to end program if someone wins
                    char currentPiece = player2.getPlayerPiece(); //piece that will be placed
                    int column;
                    int row = 0;
                    //int i;

                    do {
                        //Switch turns for players
                        if (currentPiece == player2.getPlayerPiece()) {
                            currentPiece = player1.getPlayerPiece();
                        } else if (currentPiece == player1.getPlayerPiece()) {
                            currentPiece = player2.getPlayerPiece();
                        }

                        if (currentPiece == player1.getPlayerPiece()) {
                            System.out.println(player1.getName() + ": Choose a column to drop your piece");
                        } else if (currentPiece == player2.getPlayerPiece()) {
                            System.out.println(player2.getName() + ": Choose a column to drop your piece");
                        }

                        column = input.nextInt() - 1;
                        System.out.println("\n");

                        //retry for invalid entries
                        while ((column > 6 || column < 0) || (board[0][column] == 'X' || board[0][column] == 'O')) {
                            System.out.println("Invalid entry. Try again.");

                            if (currentPiece == player1.getPlayerPiece())
                                System.out.println(player1.getName() + ": Choose a column to drop your piece");

                            else if (currentPiece == player2.getPlayerPiece())
                                System.out.println(player2.getName() + ": Choose a column to drop your piece");

                            column = input.nextInt() - 1;

                        }

                        //set row, by finding where "-" ends
                        for (int i = 0; i <= 5; i++) {
                            if (board[i][column] == '-')
                                row = i;
                                else
                                break;
                        }
                        //Place piece
                        board[row][column] = currentPiece;

                        gameBoard.printBoard(board);

                        //Win conditions
                        if (gameBoard.checkWinVerticalHorizontal(board, column, currentPiece)) {
                            win = true;
                        } else if (gameBoard.checkWinVerticalHorizontal(board, row, column, currentPiece)) {
                            win = true;
                        } else if (gameBoard.checkWinDiagonalUp(board, row, currentPiece)) {
                            win = true;
                        } else if (gameBoard.checkWinDiagonalDown(board, row, currentPiece)) {
                            win = true;
                        }

                        if (gameBoard.checkFull(board)) {
                            win = true;
                        }

                    } while (!win);

                    //Print who won, the player whos turn it is will be declared winner
                    System.out.println("GAME OVER");
                    if (gameBoard.checkFull(board)) {
                        System.out.println("No more possible moves!");
                        System.out.println("Draw!");
                    } else if (currentPiece == player1.getPlayerPiece()) {
                        System.out.println(player1.getName() + " WINS!");
                    } else if (currentPiece == player2.getPlayerPiece()) {
                        System.out.println(player2.getName() + " WINS!");
                    }

                    long end = gameStats.setCurrentTime();
                    gameStats.totalTime(end, start);
                    gameStats.getCurrentTime(end);
                    //replay
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
