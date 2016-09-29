package pl.test.questiontest;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

	final String query = "SELECT QUESTION_ID, QUESTION, ANSWER, LEVEL, IMAGE FROM question";
	private List<Question> questionsList;


	public List<Question> initMapping(QueryExecutor que, QuestionMapper map){
		return map.mapData(que.execute(query));
	}

	public QuestionDAO(QueryExecutor que, QuestionMapper map) {

		questionsList = initMapping(que, map);

	}

	public List<Question> getAllQuestions() {
		return questionsList;

	}

	public List<Question> getSecondQuestion() {
		List<Question> questionsSet = new ArrayList<Question>();
		questionsSet.add(questionsList.get(1));
		return questionsSet;
	}

	public List<Question> getEasyQuestions() {
		List<Question>questionsSet = new ArrayList<Question>();

		for (Question q : questionsList) {
			if (q.getLevel() == 0) {
				questionsSet.add(q);
			}
		}
		return questionsSet;

	}

	public List<Question> getToughQuestions() {
		List<Question>questionsSet = new ArrayList<Question>();

		for (Question q : questionsList) {
			if (q.getLevel() == 1) {
				questionsSet.add(q);
			}
		}
		return questionsSet;

	}
}
