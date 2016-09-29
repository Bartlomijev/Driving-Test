package pl.test.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ScorePaneController implements Initializable {

    @FXML
    private Label scoreLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		scoreLabel.setText("Liczba punktów:" + MainController.correctAnswers +"/"+(MainController.correctAnswers+MainController.incorrectAnswers) );

	}

}
