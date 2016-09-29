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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.test.questiontest.JdbcConnector;
import pl.test.questiontest.QueryExecutor;
import pl.test.questiontest.QuestionDAO;
import pl.test.questiontest.QuestionMapper;

public class MainController implements Initializable {

	int number = -1;
	static int correctAnswers = 0;
	static int incorrectAnswers = 0;

	JdbcConnector c = new JdbcConnector();
	QueryExecutor executor;
	QuestionMapper qm;
	QuestionDAO dao;

	@FXML
	private ContentPaneController contentPaneController;

	@FXML
	private ControlPaneController controlPaneController;

	@FXML
	private TopPaneController topPaneController;

	private void finishIt(int i) {
		if (i == 10) {

			Parent parent = null;
			try {
				parent = FXMLLoader.load(getClass().getResource("/pl/test/view/ScorePane.fxml"));
			} catch (Exception e) {
				e.printStackTrace();
			}

			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("wynik");
			stage.show();
			c.closeConnection();
		}
	}

	ImageView caseImage;

	void SetEasyPicture() {
		if (number <= 20 && number >= 0) {
			Image image = new Image("/pl/test/res/" + dao.getEasyQuestions().get(number).getImage());
			caseImage.setImage(image);
		}
	}

	void SetDifficultPicture() {
		if (number <= 20 && number >= 0) {
			Image image = new Image("/pl/test/res/" + dao.getToughQuestions().get(number).getImage());
			caseImage.setImage(image);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		c.initConnection();
		executor = new QueryExecutor(c.getConn());
		qm = new QuestionMapper();
		dao = new QuestionDAO(executor, qm);

		System.out.println(contentPaneController);
		System.out.println(controlPaneController);
		System.out.println(topPaneController);
		Button yesButton = controlPaneController.getYesButton();
		Button noButton = controlPaneController.getNoButton();
		Label questionText = contentPaneController.getQuestionText();
		Label questionNumber = topPaneController.getQuestionNumber();

		caseImage = contentPaneController.getCaseImage();

		if (WelcomePaneController.level == 0) {

			noButton.setOnAction(x -> {
				if (number >= 0 && number < 10) {
					if (dao.getEasyQuestions().get(number).getAnswer().equals("Nie")) {
						correctAnswers++;
					} else {
						incorrectAnswers++;
					}
					;
				}
				number++;
				if (number == 10) {
					finishIt(number);
				}
				if (number < 10) {
					SetEasyPicture();
					questionText.setText(dao.getEasyQuestions().get(number).getQuestion());
					questionNumber.setText("Numer pytania: " + (number + 1));

				}

			});

			yesButton.setOnAction(x -> {

				if (number >= 0 && number < 10) {
					if (dao.getEasyQuestions().get(number).getAnswer().equals("Tak")) {
						correctAnswers++;
					} else {
						incorrectAnswers++;
					}
					;
				}
				number++;
				if (number == 10) {
					finishIt(number);
				}
				if (number < 10) {
					SetEasyPicture();
					questionText.setText(dao.getEasyQuestions().get(number).getQuestion());
					questionNumber.setText("Numer pytania: " + (number + 1));

				}

			});

		}
		if (WelcomePaneController.level == 1) {
			noButton.setOnAction(x -> {

				if (number >= 0 && number < 10) {
					if (dao.getToughQuestions().get(number).getAnswer().equals("Nie")) {
						correctAnswers++;
					} else {
						incorrectAnswers++;
					}
					;
				}
				number++;
				if (number == 10) {
					finishIt(number);
				}
				if (number < 10) {
					SetDifficultPicture();
					questionText.setText(dao.getToughQuestions().get(number).getQuestion());
					questionNumber.setText("Numer pytania: " + (number + 1));

				}

			});

			yesButton.setOnAction(x -> {

				if (number >= 0 && number < 10) {
					if (dao.getToughQuestions().get(number).getAnswer().equals("Tak")) {
						correctAnswers++;
					} else {
						incorrectAnswers++;
					}
					;
				}
				number++;
				if (number == 10) {
					finishIt(number);
				}

				if (number < 10) {
					SetDifficultPicture();
					questionText.setText(dao.getToughQuestions().get(number).getQuestion());
					questionNumber.setText("Numer pytania: " + (number + 1));

				}
			});

		}
	}
}
