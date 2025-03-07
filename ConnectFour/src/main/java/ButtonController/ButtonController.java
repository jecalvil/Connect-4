package ButtonController;

import ConnectFourView.ScoreBoardPane;
import javafx.scene.control.Button;
import java.util.Random;
import Module.LogicModule;
import javafx.scene.control.Label;

public class ButtonController {

    private Button[][] buttonBoard;
    private static String turn = "";
    private LogicModule logicModule;
    private boolean winner = false;
    private Label p1, p2;
    private int p1Wins = 0;
    private int p2Wins = 0;


    public ButtonController(Button[][] buttonBoard) {
        this.buttonBoard = buttonBoard;
        logicModule = new LogicModule(buttonBoard);
        Random random = new Random();

        p1 = new Label("PLAYER 1: " + p1Wins + " WINS");
        p2 = new Label("PLAYER 2: " + p2Wins + " WINS");

        p1.setStyle("-fx-text-fill: Red; -fx-border-color: Transparent; -fx-border-width: 5px;");
        p2.setStyle("-fx-text-fill: Yellow; -fx-border-color: Transparent; -fx-border-width: 5px;");

        // Set starting turn randomly
        int randomTurn = random.nextInt(2);
        if (randomTurn == 0) {
            turn = "Red";
            p1.setStyle("-fx-text-fill: Red; -fx-border-color: Orange; -fx-border-width: 5px;");
        } else {
            turn = "Yellow";
            p2.setStyle("-fx-text-fill: Yellow; -fx-border-color: Orange; -fx-border-width: 5px;");
        }

    }

    public void handleButtonClick(int column) {

        // Fill Top Most Piece with Appropriate Color
        for (int i = 5; i >= 0; i--) {
            if (buttonBoard[i][column].getStyle().equals("-fx-background-color: Black") && winner == false) {

                // Change Piece Color
                buttonBoard[i][column].setStyle("-fx-background-color: " + turn);

                // Check for Winner
                if (logicModule.checkWinner(i, column, turn)) {
                    winner = true;
                    if (turn.equals("Red")) {
                        p1Wins++;
                        p1.setText(("PLAYER 1: " + p1Wins + " WINS"));
                    } else {
                        p2Wins++;
                        p2.setText(("PLAYER 1: " + p2Wins + " WINS"));
                    }
                }

                // Change Turn
                if (turn.equals("Yellow")) {
                    turn = "Red";
                    p1.setStyle("-fx-text-fill: Red; -fx-border-color: Orange; -fx-border-width: 5px;");
                    p2.setStyle("-fx-text-fill: Yellow; -fx-border-color: Transparent; -fx-border-width: 5px;");
                } else {
                    turn = "Yellow";
                    p2.setStyle("-fx-text-fill: Yellow; -fx-border-color: Orange; -fx-border-width: 5px;");
                    p1.setStyle("-fx-text-fill: Red; -fx-border-color: Transparent; -fx-border-width: 5px;");
                }
                break;
            }
        }

    }

    public void resetButtonClick() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                buttonBoard[i][j].setStyle("-fx-background-color: Black");
            }
        }
        winner = false;
    }

    public void buttonHoverEnter(int column) {
        for (Button[] row: buttonBoard) {
            Button button = row[column];
            button.getStyleClass().add("active-hover");
        }
    }

    public void buttonHoverExit(int column) {
        for (Button[] row: buttonBoard) {
            Button button = row[column];
            button.getStyleClass().remove("active-hover");
        }
    }

    public Label getp1Lable() {
        return this.p1;
    }

    public Label getp2Label() {
        return this.p2;
    }


}
