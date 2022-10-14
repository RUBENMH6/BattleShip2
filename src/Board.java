import java.util.Scanner;

public class Board {
    public static final char SHIP_SYMBOL = 'S';
    public static final char EMPTY_SYMBOL = '.';
    public static final char WATER_SYMBOL = '0';
    public static final char SUNK_SHIP_SYMBOL = 'X';
    public static final int NUM_ROWS = 8;
    public static final int NUM_COLS = 8;
    public static final int NUM_SHIPS = 8;
    static char[][] board = new char[NUM_ROWS][NUM_COLS];
    private int numShots = 0;
    private int sunkShips = 0;
    public boolean gameOver = false;

    public Board() {
        initBoard();
        addShips();
    }
    public static void initBoard() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                board[row][col] = EMPTY_SYMBOL;
            }
        }
    }
    public void addShips() {
        int placedShips = 0, randRow, randCol;
        while (placedShips < NUM_SHIPS) {
            randRow = (int) (Math.random() * NUM_ROWS);
            randCol = (int) (Math.random() * NUM_COLS);
            if (board[randRow][randCol] != SHIP_SYMBOL) {
                board[randRow][randCol] = SHIP_SYMBOL;
                placedShips++;
            }
        }
    }
    public void printBoard(boolean showShips) {
        printFirstLine();
        char letter = 'A';
        for (int row = 0; row < NUM_ROWS; row++) {
            System.out.print(letter + " ");
            letter++;
            for (int col = 0; col < NUM_COLS; col++) {
                if (!showShips && board[row][col] == SHIP_SYMBOL) {
                    System.out.print(EMPTY_SYMBOL + " ");
                } else {
                    System.out.print(board[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private void printFirstLine() {
        System.out.print("  ");
        for (int row = 1; row <= NUM_ROWS; row++) {
            System.out.print(row + " ");
        }
        System.out.println();
    }
    public void printStatistics() {
        System.out.println("Shots: " + numShots);
        System.out.println("Sunk ships: " + sunkShips);
    }

    public void checkGameOver() {
        if (sunkShips == NUM_SHIPS) {
            gameOver = true;
        }
    }
    public void shoot(int row, int col) {
        numShots++;
        if (board[row][col] == SHIP_SYMBOL) {
            board[row][col] = SUNK_SHIP_SYMBOL;
            sunkShips++;
        } else {
            if (board[row][col] != SUNK_SHIP_SYMBOL) {
                board[row][col] = WATER_SYMBOL;
            }
        }
    }
}
