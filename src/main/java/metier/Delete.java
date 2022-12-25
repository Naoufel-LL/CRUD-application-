package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public int i;
public int delete (int id) throws ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");

    try (Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection
        .prepareStatement("delete  from users where id = ?")) {
    	preparedStatement.setInt(1,id);
    	


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
