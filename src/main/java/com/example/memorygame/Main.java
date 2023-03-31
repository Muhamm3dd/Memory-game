/**
 * Define a package called "com.example.memorygame".
 * Import Application, FXMLLoader, Scene, Stage, and IOException.
 * Define a public class called "Main" that extends Application.
 * Override the "start" method and pass in a Stage parameter.
 * Create a new FXMLLoader object and load the "memory game.fxml" file.
 * Create a new Scene object and pass in the loaded FXML file and dimensions.
 * Set the title of the stage to "Memory Game" and set the scene to the created Scene object.
 * Show the stage.
 * Define a public static "main" method that calls the "launch" method.
 * End the class definition.
 */




package com.example.memorygame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("memory game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),
                320,
                240);
        stage.setTitle("Memory Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}