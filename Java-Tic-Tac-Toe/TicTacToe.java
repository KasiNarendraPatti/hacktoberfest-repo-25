import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        // Game setup
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        // Player X starts first
        char currentPlayer = 'X';
        boolean gameIsOver = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player 'X' starts. Enter numbers 1-3 for row and column.");
        System.out.println();

        // Main game loop
        while (!gameIsOver) {

            printBoard(board);

            int row, col;

            while (true) {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");

                // Row input
                System.out.print("Row (1-3): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter numbers only.");
                    scanner.next(); // clear invalid input
                    continue;
                }
                row = scanner.nextInt() - 1;

                // Column input
                System.out.print("Column (1-3): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter numbers only.");
                    scanner.next();
                    continue;
                }
                col = scanner.nextInt() - 1;

                // Validate move
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    break;
                } else {
                    System.out.println("This move is not valid! Either the spot is taken or it's off the board.");
                    System.out.println("Please try again.");
                }
            }

            board[row][col] = currentPlayer;

            if (checkWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("***************************");
                System.out.println("    PLAYER " + currentPlayer + " WINS! ");
                System.out.println("***************************");
                gameIsOver = true;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("***************************");
                System.out.println("        IT'S A DRAW!       ");
                System.out.println("***************************");
                gameIsOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    /**
     * Prints the current state of the game board.
     */
    public static void printBoard(char[][] board) {
        System.out.println();
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    /**
     * Checks whether the given player has won the game.
     */
    public static boolean checkWinner(char[][] board, char player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    /**
     * Checks whether the board is full.
     */
    public static boolean isBoardFull(char[][] board) {
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
