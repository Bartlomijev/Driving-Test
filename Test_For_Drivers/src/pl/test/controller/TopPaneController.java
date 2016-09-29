package pl.test.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class TopPaneController implements Initializable {

    @FXML
    private Label questionNumber;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("TopPaneController has been created");
	}

	public Label getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Label questionNumber) {
		this.questionNumber = questionNumber;
	}

}

