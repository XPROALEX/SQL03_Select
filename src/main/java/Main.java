import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM students");
            ArrayList<String> surnames = new ArrayList<>();
            while (resultSet.next()) {
                surnames.add(resultSet.getString("last_name"));
                System.out.println(resultSet.getString("first_name"));
            }
            surnames.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
