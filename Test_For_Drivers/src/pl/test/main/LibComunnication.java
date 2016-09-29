package pl.test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibComunnication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        final String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);

        final String dbPath = "jdbc:mysql://localhost:3306/test_easy_database";
        Connection conn = DriverManager.getConnection(dbPath, "root", "root");

        Statement statement = conn.createStatement();
        final String sqlQuery = "SELECT QUESTION, ANSWER FROM question";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        String question = null;
        String answer = null;
        while(resultSet.next()) {
            question = resultSet.getString("QUESTION");
            answer = resultSet.getString("ANSWER");
            System.out.println(question + " " + answer);
        }


        if(statement != null) {
            statement.close();
        }
        if(resultSet != null) {
            resultSet.close();
        }
        if(conn != null) {
            conn.close();
        }

    }
}
