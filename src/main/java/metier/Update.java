package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public int i;
public int update (User u) throws ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");

    try (Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection
        .prepareStatement("UPDATE users set login = ?,password = ?,ville= ?,email = ?  WHERE id = ?")) {
    	preparedStatement.setString(1, u.getLogin());
        preparedStatement.setString(2, u.getPassword());
        preparedStatement.setString(3, u.getVille());
        preparedStatement.setString(4, u.getEmail());
    	preparedStatement.setInt(5,u.getId());


        i = preparedStatement.executeUpdate();
       
    } catch (SQLException e) {
        // process sql exception
        printSQLException(e);
    }
    System.out.println(u.getEmail());
	return i;
}
private void printSQLException(SQLException e) {
	// TODO Auto-generated method stub
	
}

}
