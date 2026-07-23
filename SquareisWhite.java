public class SquareisWhite {

    public boolean squareIsWhite(String coordinates) {

        char column = coordinates.charAt(0);
        char row = coordinates.charAt(1);

        int columnNumber = column - 'a' + 1;
        int rowNumber = row - '0';

        if ((columnNumber + rowNumber) % 2 == 0) {
            return false;   // Black square
        } else {
            return true;    // White square
        }
    }
}