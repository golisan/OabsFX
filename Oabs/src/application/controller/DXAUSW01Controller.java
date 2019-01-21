package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Values;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DXAUSW01Controller {

	private final ObservableList<Values> data =
			FXCollections.observableArrayList(
					new Values("0", "Herr/Frau"),
					new Values("1", "Herr"),
					new Values("2", "Frau"),
					new Values("3", "eingetragener Kaufmann"),
					new Values("3", "Einzelfirma"),
					new Values("4", "AG & Cie"));
	

	public void initialize() {
		// final  TableView<Values> table = new TableView<Values>();

//		tbl_ausw.setEditable(true);
		
		col_key.setCellValueFactory(new PropertyValueFactory<Values, String>("colKey"));
		col_value.setCellValueFactory(new PropertyValueFactory<Values, String>("colValue"));
		tbl_ausw.setItems(data);

	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btn_speichern;

	@FXML
	private Button btn_schliessen;

	@FXML
	private TextField txt_header;

	@FXML
	private TableView<Values> tbl_ausw;

	@FXML
	private TableColumn<Values, String> col_key;

	@FXML
	private TableColumn<Values, String> col_value;

	@FXML
	void handleSchliessenEvent(ActionEvent event) {
		Stage stage = (Stage) btn_schliessen.getScene().getWindow();
	    stage.close();

	}

	@FXML
	void handleSpeichernEvent(ActionEvent event) {
		Stage stage = (Stage) btn_speichern.getScene().getWindow();
		stage.close();

	}

	@FXML
	void tbl_ausw(MouseEvent event) {
		
		String key  = tbl_ausw.getSelectionModel().getSelectedItem().getColKey();
		System.out.print(key + " ");
		String value  = tbl_ausw.getSelectionModel().getSelectedItem().getColValue();
		System.out.println(value);
	}

}
