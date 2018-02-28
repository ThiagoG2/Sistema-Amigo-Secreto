package br.ufrpe.amigo_secreto.gui;

import java.io.IOException;

import br.ufrpe.amigo_secreto.business.Fachada;
import br.ufrpe.amigo_secreto.business.beans.Presente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaCadastroDePresentesController {

	Fachada fachada = Fachada.getInstance();

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

	@FXML
	protected Button btnSalvar;
	@FXML
	protected Button btnCancelar;
	@FXML
	private TextField categoria;
	@FXML
	private TextField descricao;
	@FXML
	private TextField preco;

	@FXML
	public void cadastrarPresente(ActionEvent event) {
		try {
			String c = categoria.getText().toString();
			String d = descricao.getText().toString();
			double valor = Double.parseDouble(preco.getText());
			if (!(c.equals("") || d.equals("") || valor <= 0)) {
				Presente p = new Presente(c, d, valor);
				fachada.cadastrarPresente(p);
				Alert alert = new Alert(AlertType.INFORMATION, "Presente cadastrado com sucesso!");
				alert.setTitle("Confirmação");
				alert.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Campos preeenchidos incorretamente, tente novamente!");
				alert.show();
			}
		} catch (NumberFormatException npe) {
			Alert alert = new Alert(AlertType.ERROR, "Campos preeenchidos incorretamente ou não preenchidos!");
			alert.show();
		} catch (NullPointerException npe) {
			Alert alert = new Alert(AlertType.ERROR, "Campos preeenchidos incorretamente ou não preenchidos!");
			alert.show();
		} finally {
			limparCamposCadastro();
		}
	}

	public void limparCamposCadastro() {
		categoria.setText("");
		descricao.setText("");
		preco.setText(null);
	}

	@FXML
	public void cancelar(ActionEvent event) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION,
				"Deseja cancelar o cadastro de presentes e retornar para a tela principal?");
		alert.setTitle("Voltar para tela principal");
		alert.showAndWait().ifPresent(type -> {
			if (alert.getResult() == ButtonType.OK) {
				BorderPane testPane;
				try {
					testPane = FXMLLoader
							.load(getClass().getResource("/br/ufrpe/amigo_secreto/gui/tela principal.fxml"));
					Scene scene = new Scene(testPane);
					Stage primaryStage = new Stage(StageStyle.DECORATED);
					primaryStage.setScene(scene);
					primaryStage.setTitle("Tela Principal");
					primaryStage.show();
					btnCancelar.getScene().getWindow().hide();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
