package Module;

import javafx.scene.control.Button;

public class LogicModule {

    private Button[][] gameboard;
    private int ROWS = 6;
    private int COLUMNS = 7;
    private String color;

    public LogicModule (Button[][] gameboard) {
        this.gameboard = gameboard;
    }

    public boolean checkWinner(int row, int column, String color) {
        color = "-fx-background-color: " + color;
        // Check vertical - (row changes, column stays same)
        return checkDirection(row, column, color, 1, 0) ||
        // Check horizontal - (row stays same, column changes)
        checkDirection(row, column, color, 0, 1) ||
        // Check diagonal \ - (either both row and column inc or dec)
        checkDirection(row, column, color, 1, -1) ||
        // Check diagonal / - (either row dec & column inc, or row inc, & column dec)
        checkDirection(row, column, color, 1, 1);
    }

    private boolean checkDirection (int row, int column, String color, int rowChange, int columnChange) {
        int count = 1; // Starting Piece

        // Check Forward
        for (int i = 1; i < 4; i++) {
            int r = row + i * rowChange;
            int c = column + i * columnChange;

            // Add to count if it is inbounds and right color
            if (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && gameboard[r][c].getStyle().equals(color)) {
                count++;
            } else {
                break;
            }
        }
        // Check Backward
        for (int i = 1; i < 4; i++) {
            int r = row - i * rowChange;
            int c = column - i * columnChange;

            // Add to count if it is inbounds and right color
            if (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && gameboard[r][c].getStyle().equals(color)) {
                count++;
            } else {
                break;
            }
        }
        return count >= 4;
    }
}
