package pl.test.questiontest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionMapper {


	public QuestionMapper() {

	}

	public List<Question> mapData (ResultSet resultset) {
		int questionId = 0;
		String questionName = null;
		String answerName = null;
		int level = 0;
		String image = null;
		List<Question> questionsList = new ArrayList<Question>();
		try {
			while (resultset.next()) {

				Question quest = new Question(0, null, null, 0, null);
				questionId = resultset.getInt("QUESTION_ID");
				quest.setQuestionId(questionId);
				questionName = resultset.getString("QUESTION");
				quest.setQuestion(questionName);
				answerName = resultset.getString("ANSWER");
				quest.setAnswer(answerName);
				level = resultset.getInt("LEVEL");
				quest.setLevel(level);
				image = resultset.getString("IMAGE");
				quest.setImage(image);

				questionsList.add(quest);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionsList;
	}

}