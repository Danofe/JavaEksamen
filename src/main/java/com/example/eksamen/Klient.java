package com.example.eksamen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.PublicKey;

public class Klient extends Application {

    public static Label lbl;
    public static TextField txf;

    public static Button btn;


    @Override
    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();

        lbl = new Label("Navn:");
        txf = new TextField("Skriv inn navnet ditt her:");
        btn = new Button("Ok");

        vBox.getChildren().addAll(lbl, txf, btn);

        pane.setCenter(vBox);




        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("EksamensKlient");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}