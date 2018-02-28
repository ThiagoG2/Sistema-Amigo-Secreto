package br.ufrpe.amigo_secreto.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import br.ufrpe.amigo_secreto.business.Fachada;
import br.ufrpe.amigo_secreto.business.beans.Grupo;
import br.ufrpe.amigo_secreto.business.beans.Pessoa;
import br.ufrpe.amigo_secreto.business.exception.PoucasPessoasNoGrupoException;
import br.ufrpe.amigo_secreto.business.exception.SorteioJaRealizadoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaSorteioController implements Initializable {
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
	private ComboBox<Grupo> listaGrupos;
	@FXML
	private ComboBox<Grupo> listaGrupos2;

	private List<Grupo> listarGrupos = new ArrayList<>();
	private ObservableList<Grupo> obsLista;

	@FXML
	public void listarGrupos() {
		listarGrupos.addAll(fachada.listarGrupos());
		obsLista = FXCollections.observableArrayList(listarGrupos);

		listaGrupos.getItems().addAll(obsLista);
		listaGrupos2.getItems().addAll(obsLista);
	}

	@FXML
	private ComboBox<Pessoa> listaPessoas;
	private ObservableList<Pessoa> obsListaPessoa;

	@FXML
	public void listarPessoas() {
		listaPessoas.getItems().clear();
		Grupo g = listaGrupos2.getSelectionModel().getSelectedItem();
		obsListaPessoa = FXCollections.observableArrayList(g.getListaParticipantes());
		Collections.shuffle(obsListaPessoa);
		listaPessoas.getItems().addAll(obsListaPessoa);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarGrupos();
	}

	@FXML
	private Button btnConsultarAmigoSecreto;
	@FXML
	private PasswordField password;

	@FXML
	public void consultarAmigoSecreto() throws SorteioJaRealizadoException {
		Grupo g = listaGrupos2.getSelectionModel().getSelectedItem();
		Pessoa p = listaPessoas.getSelectionModel().getSelectedItem();
		String senha = password.getText().toString();
		if (!(senha.equals("") || p == null || g == null)) {
			Pessoa pessoa = fachada.consultarAmigoSecreto(g, p, senha);
			if (pessoa != null) {
				Alert alert = new Alert(AlertType.INFORMATION, "Amigo secreto de " + p + " no " + g + " é " + pessoa);
				alert.setTitle("Amigo Secreto");
				alert.show();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION, "Sorteio ainda não realizado ou Senha errada!");
				alert.show();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR,
					"Você não selecionou um grupo e uma pessoa ou não digitou uma senha!");
			alert.show();
		}
	}

	@FXML
	private Button btnRealizarSorteio;

	@FXML
	public void realizarSorteio() throws SorteioJaRealizadoException, PoucasPessoasNoGrupoException {
		try {
			Grupo g = listaGrupos.getSelectionModel().getSelectedItem();
			if (g.getDataSorteio().equals(LocalDate.now())) {
				fachada.gerarSorteio(g.getNomeGrupo());
				Alert alert = new Alert(AlertType.INFORMATION, "Sorteio realizado com sucesso!");
				alert.setTitle("Sorteio");
				alert.show();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION, "O sorteio deste grupo não está programado para hoje!");
				alert.show();
			}
		} catch (SorteioJaRealizadoException sjr) {
			Alert alert = new Alert(AlertType.INFORMATION, "Sorteio já realizado pra esse grupo!");
			alert.show();
		} catch (NullPointerException npe) {
			Alert alert = new Alert(AlertType.ERROR, "Nenhum grupo foi selecionado!");
			alert.show();
		} catch (PoucasPessoasNoGrupoException ppe) {
			Alert alert = new Alert(AlertType.ERROR,
					"Não é possível realizar o sorteio de amigo secreto com menos de 2 pessoas no grupo do amigo secreto, adicione mais pessoas!");
			alert.show();
		}
	}
}
