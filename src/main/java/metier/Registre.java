package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registre {
	public int i;
public int registre (User u) throws ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");

    try (Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection
        .prepareStatement("INSERT INTO users VALUES (?,?,?,?,?)")) {
    	preparedStatement.setInt(1, u.getId());
    	preparedStatement.setString(2, u.getLogin());
        preparedStatement.setString(3, u.getPassword());
        preparedStatement.setString(4, u.getVille());
        preparedStatement.setString(5, u.getEmail());


        i = preparedStatement.executeUpdate();
       
    } catch (SQLException e) {
        // process sql exception
        printSQLException(e);
    }
	return i;
}
private void printSQLException(SQLException e) {
	// TODO Auto-generated method stub
	
}

}
