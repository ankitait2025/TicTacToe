/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

/**
 *
 * @author LENOVO-PC
 */



import java.util.Scanner;

public class TicTacToe {

    // The game board
    private static char[][] board = new char[3][3];
    
    // The current player
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        // Initialize the board
        initializeBoard();

        // Game loop
        while (true) {
            printBoard();
            playerMove();
            
            if (isWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            
            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Initialize the board with empty spaces
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current state of the board
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Get the player's move
    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column from 0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    // Check if the current player has won
    private static boolean isWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
        }
        
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        
        return false;
    }

    // Check if the board is full
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
