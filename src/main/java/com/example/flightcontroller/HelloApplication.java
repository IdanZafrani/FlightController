package com.example.flightcontroller;

import controller.controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.model;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = (Parent) fxmlLoader.load(); // get the root to my XML
        HelloController helloController = fxmlLoader.getController();
        helloController.paint();
        model m = new model("properties.txt");
        controller c = new controller(m,helloController);
        Scene scene = new Scene(root, 320, 240); // creat window base on my root
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}