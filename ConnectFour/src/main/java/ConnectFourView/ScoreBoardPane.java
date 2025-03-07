package ConnectFourView;

import ButtonController.ButtonController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ScoreBoardPane extends HBox {

    private Button reset;
    private Button mainMenu;
    private Label player1Label;
    private Label player2Label;
    private Font retroFont = Font.loadFont(getClass().getResourceAsStream("/PressStart2P-Regular.ttf"), 12);
    private BoardPane boardPane;
    private ButtonController buttonController;

    public ScoreBoardPane(BoardPane boardPane) {
        this.boardPane = boardPane;
        buttonController = boardPane.getButtonController();

        // Declare Buttons
        reset = new Button("Reset"); // Reset Buttons
        mainMenu = new Button("Connect-4"); // Main Menu Button - still needs funcitonality

        // Button events

        // reset
        reset.setOnAction(event -> {
            buttonController.resetButtonClick();
        });

        reset.setOnMouseEntered(event -> {
            reset.setStyle("-fx-background-color: Purple; -fx-text-fill: Black;");
        });

        reset.setOnMouseExited(event -> {
            reset.setStyle("-fx-background-color: Black; -fx-text-fill: Purple;");
        });

        // menu
        mainMenu.setOnMouseEntered(event -> {
            mainMenu.setStyle("-fx-background-color: Purple; -fx-text-fill: Black;");
        });

        mainMenu.setOnMouseExited(event -> {
            mainMenu.setStyle("-fx-background-color: Black; -fx-text-fill: Purple;");
        });

        // Declare Labels
        player1Label = buttonController.getp1Lable();
        player2Label = buttonController.getp2Label();

        // Labels Styling
        player1Label.setFont(retroFont);
        player2Label.setFont(retroFont);

        // Buttons Styling
        reset.setFont(retroFont);
        reset.setStyle("-fx-background-color: Black; -fx-text-fill: Purple; -fx-border-color: blue;");

        mainMenu.setFont(retroFont);
        mainMenu.setStyle("-fx-background-color: Black; -fx-text-fill: Purple; -fx-border-color: blue;");
        // Add to ScoreBoard
        this.getChildren().add(player1Label);
        this.getChildren().add(reset);
        this.getChildren().add(mainMenu);
        this.getChildren().add(player2Label);

        // ScoreBoard Tweaks
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50, 0, 0, 0));
    }

    public Label getPlayer1Label() {
        return this.player1Label;
    }

    public Label getPlayer2Label() {
        return this.player2Label;
    }

}
