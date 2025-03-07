package com.example.connectfour;

import ButtonController.ButtonController;
import ConnectFourView.BoardPane;
import ConnectFourView.ScoreBoardPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class ConnectFourApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException{

        // Create Container
        VBox container = new VBox();
        container.setStyle("-fx-background-color: #003366;");

        // Create Views
        BoardPane board = new BoardPane();
        board.setAlignment(Pos.CENTER);
        ScoreBoardPane scoreBoard = new ScoreBoardPane(board);
        scoreBoard.setAlignment(Pos.CENTER);

        // Add Views to Container
        container.getChildren().add(scoreBoard);
        container.getChildren().add(board);

        // Stage
        Scene scene = new Scene(container, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
