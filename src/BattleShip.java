
public class BattleShip {

    public static void main(String[] args) {
        int row, col;
        boolean gameOver = false;

        Board board = new Board();
        ImputManager imputManager = new ImputManager();

        while (!gameOver) {
            board.printStatistics();
            board.printBoard(false);
            row = imputManager.enterRow();
            col = imputManager.enterCol();
            board.shoot(row,col);
            board.checkGameOver();
        }
        System.out.println("GAME OVER");
        board.printStatistics();
        board.printBoard(true);

    }
}