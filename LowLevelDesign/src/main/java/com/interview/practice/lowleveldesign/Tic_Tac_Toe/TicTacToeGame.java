package com.interview.practice.lowleveldesign.Tic_Tac_Toe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TicTacToeGame {

    public static void main(String[] args) {

        /* create board
         create 2 players -- assign them mark
         start the game
         show board before the move
         if added successfully, check for winner OR draw OR continue the game
         if not added successfully, same player will play again. */

        /* additional features
        1. support N * N board
         */


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean toRestart = true;
            System.out.println("Enter the size of the board ::");
            String size = bufferedReader.readLine();
            Board board = new Board(Integer.parseInt(size));
            Player player1 = new Player("Player1", MarkEnumType.X);
            Player player2 = new Player("Player2", MarkEnumType.O);

            ArrayDeque<Player> queue = new ArrayDeque<>();
            queue.add(player1);
            queue.add(player2);

            while (toRestart) {

                while (true) {
                    board.printBoard();
                    Player currentPlayer = queue.pop();

                    System.out.println(currentPlayer.getName() + " enter ROW and COLUMN position ::");

                    String[] line = bufferedReader.readLine().split(" ");
                    int row = Integer.parseInt(line[0]);
                    int col = Integer.parseInt(line[1]);

                    if (board.addPiece(row, col, currentPlayer.getMark())) {
                        if (board.isWinner(row, col)) {
                            System.out.println(currentPlayer.getName() + " is the winner");
                            break;
                        }

                        if (board.isDraw()) {
                            System.out.println("It's a draw");
                            break;
                        }

                        queue.addLast(currentPlayer);
                    } else {
                        System.out.println("Invalid move. Try again");
                        queue.addFirst(currentPlayer);
                    }
                }

                System.out.println("Do you want to restart the game? (Y/N)");
                String line = bufferedReader.readLine();
                if (line.equalsIgnoreCase("N")) {
                    toRestart = false;
                } else {
                    board = new Board(Integer.parseInt(size));
                    queue.clear();
                    queue.add(player1);
                    queue.add(player2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
