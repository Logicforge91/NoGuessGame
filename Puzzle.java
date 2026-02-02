import java.util.Arrays;
import java.util.Scanner;

public class Puzzle {
    
    static String[] board;
    static String turn;
    
    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
    
    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            
            if (line.equals("XXX")) {
                return "X";
            }
            
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }
        
        return null;
    }
    
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        
        System.out.println("Welcome to 3x3 Tic Tac Toe!");
        printBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");
        
        String winner = null;
        
        while (winner == null) {
            int numInput;
            
            try {
                numInput = scanner.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input; re-enter slot number:");
                scanner.next(); // Clear invalid input
                continue;
            }
            
            // Check if slot is already taken
            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = turn;
                
                // Switch turns
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                
                printBoard();
                winner = checkWinner();
                
                if (winner == null) {
                    System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
                }
            } else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }
        
        // Game result
        if (winner.equals("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + " has won! Thanks for playing.");
        }
        
        scanner.close();
    }
}