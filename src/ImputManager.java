import java.util.Scanner;

public class ImputManager {
    Scanner input = new Scanner (System.in);
    public int enterCol() {

        System.out.print("Enter col: ");
        int col = input.nextInt();
        return col - 1;
    }
    public int enterRow() {

        System.out.print("Enter row: ");
        String text = input.next().toUpperCase();
        char letter = text.charAt(0);
        int row = letter - 'A';
        return row;
    }

}
