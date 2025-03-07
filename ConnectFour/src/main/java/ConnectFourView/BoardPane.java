package ConnectFourView;

import ButtonController.ButtonController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class BoardPane extends GridPane {

    private Button[][] gameBoard;
    private ButtonController buttonController;
    private int rows;
    private int columns;
    private Label p1;
    private Label p2;

    public BoardPane() {
        this.p1 = p1;
        this.p2 = p2;

        // Declare Rows and Column #s
        rows = 6;
        columns = 7;

        // Create Board with rows and columns
        gameBoard = new Button[rows][columns];

        // Controller
        buttonController = new ButtonController(gameBoard);

        // Create Buttons
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                // Create Individual Button
                gameBoard[i][j] = new Button("");
                Button button = gameBoard[i][j];

                // Button Tweaks
                button.setPrefSize(100,100); // Size
                button.setStyle("-fx-background-color: Black"); // Set to Black
                Circle circle = new Circle(50);
                button.setShape(circle);

                // Add Button to GridPane
                this.add(button, j, i);
                button.getStyleClass().add("custom-button");

                // Button Functionality
                // int row = i;
                int column = j;

                button.setOnAction(event -> {
                    buttonController.handleButtonClick(column);
                });

                button.setOnMouseEntered(event -> {
                    buttonController.buttonHoverEnter(column);
                });

                button.setOnMouseExited(event -> {
                    buttonController.buttonHoverExit(column);
                });


                // GridPane Tweaks
                this.setPadding(new Insets(50));
            }
        }
    }

    public Button[][] getGameBoard() {
        return this.gameBoard;
    }

    public ButtonController getButtonController() {
        return this.buttonController;
    }
}
