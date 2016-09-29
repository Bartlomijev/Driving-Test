package pl.test.questiontest;

public class Question {

	private int questionId;
	private String question;
	private String answer;
	private int level;
	private String image;

	public Question() {}

	public Question(int questionId, String question, String answer,int level, String image) {
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
		this.level = level;
		this.image = image;
	}


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answer=" + answer + ", level="
				+ level + ", image=" + image + "]";
	}




}
