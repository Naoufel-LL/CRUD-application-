package metier;
import java.sql.*; 
import java.util.*; 
public class UserImpl {
public List<User> getClientsParV(String v){  
List<User> allusers=new ArrayList<User>();  
Connection conn=SingletonConnection.getConnection();  
try {
PreparedStatement ps=conn.prepareStatement  ("select * from users where ville like ?");  
ps.setString(1, "%"+v+"%");
ResultSet rs=ps.executeQuery();  
while(rs.next()){
User u=new User();  
u.setId(rs.getInt("id"));  
u.setLogin(rs.getString("login"));  
u.setEmail(rs.getString("EMAIL"));  
u.setVille(rs.getString("VILLE"));  
allusers.add(u);
}
} catch (SQLException e) {  e.printStackTrace();
}
return allusers;
  }}
