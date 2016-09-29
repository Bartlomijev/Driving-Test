package pl.test.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControlPaneController implements Initializable {

	private int number;

	@FXML
	private Button yesButton;

	@FXML
	private Button noButton;

	@FXML
	private void previousQuestion(ActionEvent actionevent) {

	}

	@FXML
	private void nextQuestion(ActionEvent actionevent) {

	}

	@FXML
	private void yesAnswer(ActionEvent actionevent) {

	}

	@FXML
	private void noAnswer(ActionEvent actionevent) {

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("ControlPaneController has been created");
	}


	public Button getYesButton() {
		return yesButton;
	}

	public void setYesButton(Button yesButton) {
		this.yesButton = yesButton;
	}

	public Button getNoButton() {
		return noButton;
	}

	public void setNoButton(Button noButton) {
		this.noButton = noButton;
	}

	public int getNumber() {
		return number++;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
