package application.controller;

import java.io.IOException;

import application.AlertHelper;
import application.Ids;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class DGAGXX01Controller {
	public void initialize() {
		PGArt.setItems(FXCollections.observableArrayList(
				"Amtsgericht", "Landgericht", 
				"Landgericht-KFH", "Amtsgericht-Familiengericht",
				"Sozialgericht")
				);

	}

	@FXML
	private TextField anr;

	@FXML
	private TextField anrText;

	@FXML
	private Button btn_anr_Such;

	@FXML
	private Button btn_GV;

	@FXML
	private TextField name1;

	@FXML
	private TextField name2;

	@FXML
	private TextField name3;

	@FXML
	private TextField name4;

	@FXML
	private TextField str;

	@FXML
	private TextField plz;

	@FXML
	private Button btn_plzSuch;

	@FXML
	private TextField ort;

	@FXML
	private ChoiceBox<String> PGArt;

	@FXML
	private TextField abt;

	@FXML
	private TextField PGPLz;

	@FXML
	private TextField PGOrt;

	@FXML
	private Button btn_PGErmitteln;

	@FXML
	private Button btn_neu;

	@FXML
	private Button btn_loeschen;

	@FXML
	private Button btn_speichern;

	@FXML
	private Button btn_schliessen;

	@FXML
	private Button btn_beenden;

	@FXML
	protected void handleSchliessenEvent(ActionEvent event) {
		Platform.exit();

	}

	@FXML
	protected void handleSpeichernEvent(ActionEvent event) {
		Window owner = btn_speichern.getScene().getWindow();
		String s =anr.getText().trim(); 
		if(s.isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Fehler", 
					"Anrede darf nicht leer sein!");
			anr.requestFocus();
			return;
		}

	}
	@FXML
	protected void handleAnr_Such(ActionEvent event) {
		Stage stage = new Stage();
		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DXAUSW01.fxml"));

			root = loader.load();
			DXAUSW01Controller controller = loader.getController();
			
			application.Parameter parameter = new application.Parameter();
			parameter.setInId(Ids.ID_AGANRRF);
			controller.setParameter(parameter);
			
			stage.setScene(new Scene(root));
			stage.setTitle("Auswahl Anrede/Rechtsform");
			stage.initModality(Modality.WINDOW_MODAL);
			Window owner = ((Node)event.getSource()).getScene().getWindow();
			stage.initOwner(owner);
			
			stage.showAndWait();

			if (controller.getParameter().isOk()){
				anr.setText(controller.getParameter().getOutData()[0]);
				anrText.setText(controller.getParameter().getOutData()[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


	@FXML
	protected void handlePlz_Such(ActionEvent event) {
		Stage stage = new Stage();
		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DXAUSW01.fxml"));

			root = loader.load();
			DXAUSW01Controller controller = loader.getController();
			
			application.Parameter parameter = new application.Parameter();
			parameter.setInId(Ids.ID_ORTE);
			controller.setParameter(parameter);
			
			stage.setScene(new Scene(root));
			stage.setTitle("Ortssuche");
			stage.initModality(Modality.WINDOW_MODAL);
			Window owner = ((Node)event.getSource()).getScene().getWindow();
			stage.initOwner(owner);
			
			stage.showAndWait();

			if (controller.getParameter().isOk()){
				plz.setText(controller.getParameter().getOutData()[0]);
				ort.setText(controller.getParameter().getOutData()[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}




}
