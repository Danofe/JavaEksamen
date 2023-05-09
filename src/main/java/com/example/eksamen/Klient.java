package com.example.eksamen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Klient extends Application {

    public static Label lbl;
    public static TextField txf;

    public static Button btn;
    public static ChoiceBox<String> cb;

    public static int h = 1000;
    public static int w = 1000;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        HBox vBox = new HBox();

        lbl = new Label("Navn:");
        txf = new TextField("Skriv inn navnet ditt her:");
        btn = new Button("Ok");
        cb = new ChoiceBox<>();

        btn.setOnAction(e -> {
            KlientLogikk klientlogikk = new KlientLogikk();
            List<String> examSetList = klientlogikk.hentEksamensSett("localhost", 8080);

            cb.getItems().addAll(examSetList);

        });


        vBox.getChildren().addAll(lbl, txf, btn, cb);

        pane.setCenter(vBox);

        Scene scene = new Scene(pane, h, w);
        stage.setTitle("EksamensKlient");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}