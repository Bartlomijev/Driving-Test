package pl.test.questiontest;

public class TestingClass {

	public static void main(String[] args) {

		JdbcConnector c = new JdbcConnector();
		c.initConnection();
		QueryExecutor executor = new QueryExecutor(c.getConn());
		QuestionMapper qm = new QuestionMapper();
		QuestionDAO dao = new QuestionDAO(executor, qm);

		System.out.println(dao.getAllQuestions());
		System.out.println(dao.getSecondQuestion().get(0).getQuestion());
		System.out.println("}}}}}}}");
		System.out.println(dao.getSecondQuestion());
		System.out.println("-----");
		System.out.println(dao.getEasyQuestions());
		System.out.println("////////");
		System.out.println(dao.getToughQuestions());
		c.closeConnection();

	}
}
