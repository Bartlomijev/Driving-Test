package pl.test.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class ContentPaneController implements Initializable {

	@FXML
	private ImageView caseImage;

	@FXML
	  private Label questionText;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//ContentPaneController p = new ContentPaneController();
		System.out.println("ContentPaneController has been created");

	}



	public ImageView getCaseImage() {
		return caseImage;
	}



	public void setCaseImage(ImageView caseImage) {
		this.caseImage = caseImage;
	}



	public Label getQuestionText() {
		return questionText;
	}



	public void setQuestionText(Label questionText) {
		this.questionText = questionText;
	}


}