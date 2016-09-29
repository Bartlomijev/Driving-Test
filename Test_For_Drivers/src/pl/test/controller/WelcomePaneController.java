package pl.test.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WelcomePaneController implements Initializable {


	static int level = 0;



	@FXML
	private Label welcomeLabel;

	@FXML
	private Button difficult;

	@FXML
	private Button easy;

	MainController mp = new MainController();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		difficult.setOnAction(x -> {

			level = 1;
			System.out.println("wybrano pozion trudny");

			Parent parent = null;
			try {
				parent = FXMLLoader.load(getClass().getResource("/pl/test/view/MainPane.fxml"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("test");
			stage.show();


		});

		easy.setOnAction(x -> {

			System.out.println("wybrano poziom łatwy ");

			Parent parent = null;
			try {
				parent = FXMLLoader.load(getClass().getResource("/pl/test/view/MainPane.fxml"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("start");
			stage.show();

		});

	}
}
