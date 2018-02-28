package br.ufrpe.amigo_secreto.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BorderPane testPane = FXMLLoader.load(getClass()
                .getResource("/br/ufrpe/amigo_secreto/gui/tela principal.fxml"));
        
        Scene scene = new Scene(testPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tela Principal");
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
