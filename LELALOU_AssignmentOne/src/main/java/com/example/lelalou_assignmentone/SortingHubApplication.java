package com.example.lelalou_assignmentone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SortingHubApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SortingHubApplication.class.getResource("SortingHub-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("SortingHub");
        stage.setScene(scene);
        Image icon = new Image("file:src/main/resources/com/example/lelalou_assignmentone/WesternLogo.png");
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}