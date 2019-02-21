package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Oabs extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException {
      	 FXMLLoader loader = new FXMLLoader(getClass().getResource("view/DGAGXX01.fxml"));
    	 Parent root = loader.load();

         Scene scene = new Scene(root, 1280, 950);
         stage.setTitle("Antragsgegner");
         stage.setScene(scene);
         stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}