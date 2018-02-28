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
import br.ufrpe.amigo_secreto.business.exception.GrupoExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaGruposController implements Initializable {
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
	private TextField nomeGrupo;
	@FXML
	private DatePicker data;

	@FXML
	public void cadastrarGrupos(ActionEvent event) throws GrupoExisteException, IOException {
		try {
			String nome = nomeGrupo.getText().toString();
			LocalDate date = data.getValue();
			if ((date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now())) && nome != null) {
				Grupo g = new Grupo(nome, date);
				fachada.cadastrarGrupo(g);
				Alert alert = new Alert(AlertType.INFORMATION, "Grupo cadastrado com sucesso!");
				alert.setTitle("Confirmação");
				alert.showAndWait();
				abreTelaGrupos(event);
			} else {
				Alert alert = new Alert(AlertType.INFORMATION,
						"Não é possível cadastrar um grupo para o sorteio em uma data passada, tente novamente em outra data!");
				alert.show();
			}
		} catch (GrupoExisteException ge) {
			Alert alert = new Alert(AlertType.INFORMATION, "Já existe um grupo com esse nome, tente novamente!");
			alert.show();
		} catch (NullPointerException npe) {
			Alert alert = new Alert(AlertType.ERROR, "Campos não preenchidos corretamente!");
			alert.show();
		} finally {
			limparCamposCadastro();
		}
	}

	public void limparCamposCadastro() {
		nomeGrupo.setText(null);
		data.setValue(null);
	}

	@FXML
	private ComboBox<Grupo> lista;
	private List<Grupo> listarGrupos = new ArrayList<>();
	private ObservableList<Grupo> obsLista;

	@FXML
	public void listarGrupos() {
		listarGrupos.addAll(fachada.listarGrupos());
		obsLista = FXCollections.observableArrayList(listarGrupos);

		lista.getItems().addAll(obsLista);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarGrupos();
		listarPessoas();
	}

	@FXML
	private ListView<Pessoa> viewAllPessoas;

	private List<Pessoa> listarPessoas = new ArrayList<>();
	private ObservableList<Pessoa> p;

	public void listarPessoas() {
		listarPessoas.addAll(fachada.listarPessoa());
		p = FXCollections.observableArrayList(listarPessoas);
		viewAllPessoas.getItems().addAll(p);
	}

	@FXML
	private Button btnAdicionar;
	@FXML
	private ListView<Pessoa> viewPessoasNoGrupo;
	private ObservableList<Pessoa> pp;

	@FXML
	public void pegarComboSelecionado() {
		try {
			viewPessoasNoGrupo.getItems().clear();
			Grupo g = lista.getSelectionModel().getSelectedItem();
			if (!fachada.existeSorteio(g.getNomeGrupo())) {
				if (viewAllPessoas.getSelectionModel().getSelectedItem() != null) {
					Pessoa p = viewAllPessoas.getSelectionModel().getSelectedItem();

					List<Pessoa> pessoas = g.getListaParticipantes();
					boolean verificar = false;
					if (pessoas.size() == 0) {
						g.setListaParticipantes(p);
					} else {
						for (int i = 0; i < pessoas.size(); i++) {
							if (p.equals(pessoas.get(i))) {
								verificar = true;
							}
						}
						if (!verificar) {
							g.setListaParticipantes(p);
						} else {
							Alert alert = new Alert(AlertType.ERROR, "Pessoa já cadastrada no grupo!");
							alert.show();
						}
					}
				} else {
					Alert alert = new Alert(AlertType.ERROR, "Você não selecionou uma pessoa!");
					alert.show();
				}
				pp = FXCollections.observableArrayList(g.getListaParticipantes());
				viewPessoasNoGrupo.getItems().addAll(pp);
			} else {
				pp = FXCollections.observableArrayList(g.getListaParticipantes());
				viewPessoasNoGrupo.getItems().addAll(pp);
				Alert alert = new Alert(AlertType.ERROR,
						"Sorteio para este grupo já foi realizado, não é possível" + " adicionar mais pessoas!");
				alert.show();
			}
		} catch (NullPointerException npe) {
			Alert alert = new Alert(AlertType.ERROR, "Você não selecionou um grupo!");
			alert.show();
		}
	}

	@FXML
	public void pegarCombo() {
		viewPessoasNoGrupo.getItems().clear();
		Grupo g = lista.getSelectionModel().getSelectedItem();
		pp = FXCollections.observableArrayList(g.getListaParticipantes());
		Collections.shuffle(pp);
		viewPessoasNoGrupo.getItems().addAll(pp);
	}

	@FXML
	public void cancelar(ActionEvent event) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION,
				"Deseja cancelar o cadastro de grupos e retornar para a tela principal?");
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

	@FXML
	private Button btnRemover;

	@FXML
	public void removerPessoaDoGrupo() {
		Grupo grupo = lista.getSelectionModel().getSelectedItem();
		Pessoa pessoa = viewPessoasNoGrupo.getSelectionModel().getSelectedItem();
		if (grupo != null && pessoa != null) {
			viewPessoasNoGrupo.getItems().remove(pessoa);
			grupo.getListaParticipantes().remove(pessoa);
		} else if (grupo != null && pessoa == null) {
			Alert alert = new Alert(AlertType.ERROR,
					"Você não selecionou uma pessoa do grupo selecionado para deletar!");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Você não selecionou um grupo para deletar as pessoas!");
			alert.show();
		}
	}
}
