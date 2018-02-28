package br.ufrpe.amigo_secreto.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaPrincipalController {
	@FXML
	protected Button btnPessoas;
	@FXML
	protected Button btnGrupos;
	@FXML
	protected Button btnPresentes;
	@FXML
	protected Button btnSorteio;

	@FXML
	public void abreTelaPessoas(ActionEvent event) throws IOException {
		BorderPane testPane = FXMLLoader.load(getClass().getResource("/br/ufrpe/amigo_secreto/gui/pessoas.fxml"));

		Scene scene = new Scene(testPane);
		Stage primaryStage = new Stage(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pessoas");
		primaryStage.show();
		btnPessoas.getScene().getWindow().hide();
	}

	@FXML
	public void abreTelaGrupos(ActionEvent event) throws IOException {
		BorderPane testPane = FXMLLoader.load(getClass().getResource("/br/ufrpe/amigo_secreto/gui/grupos.fxml"));

		Scene scene = new Scene(testPane);
		Stage primaryStage = new Stage(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Grupos");
		primaryStage.show();
		btnGrupos.getScene().getWindow().hide();
	}

	@FXML
	public void abreTelaPresentes(ActionEvent event) throws IOException {
		BorderPane testPane = FXMLLoader
				.load(getClass().getResource("/br/ufrpe/amigo_secreto/gui/cadastro de presentes.fxml"));

		Scene scene = new Scene(testPane);
		Stage primaryStage = new Stage(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cadastro de Presentes");
		primaryStage.show();
		btnPresentes.getScene().getWindow().hide();
	}

	@FXML
	public void abreTelaSorteio(ActionEvent event) throws IOException {
		BorderPane testPane = FXMLLoader.load(getClass().getResource("/br/ufrpe/amigo_secreto/gui/sorteio.fxml"));

		Scene scene = new Scene(testPane);
		Stage primaryStage = new Stage(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sorteio");
		primaryStage.show();
		btnSorteio.getScene().getWindow().hide();
	}
}
