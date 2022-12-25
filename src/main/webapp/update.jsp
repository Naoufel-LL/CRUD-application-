<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 <%@page import="java.util.*"%>
 <%@page import="java.sql.*"%>
 <%@page import="metier.SingletonConnection"%>
  <%@page import="metier.User"%>
 
 <%
 int id = Integer.parseInt(request.getParameter("id"));

 %>
 <%
  
 final class Getupdate {
	 public User getClientInfo(int id){  
	 Connection conn=SingletonConnection.getConnection();
	 User user=new User();
	 try {
	 PreparedStatement ps=conn.prepareStatement  ("select * from users where id = ?");  
	 ps.setInt(1,id);
	 ResultSet rs=ps.executeQuery();  
	 while(rs.next()){
	 user.setId(rs.getInt("id"));  
	 user.setLogin(rs.getString("login"));  
	 user.setEmail(rs.getString("email"));  
	 user.setVille(rs.getString("VILLE")); 
	 }
	 } catch (SQLException e) {  e.printStackTrace();
	 }
	 return user;

	   }}

%>
<%
   Getupdate user = new Getupdate();
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);
body{
 margin-top:8%;
  background-color: #04AA6D;
}
table tr{
 padding:20px;
}
h1{
  color:white;
  font-family:sans-serif;
}
.btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
  border-radius:10px;
  opacity: 0.9;
}
input{
font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 180%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

</style>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
 <div align="center">
  <h1>Update Form</h1>
  <form action="<%=request.getContextPath()%>/up?id=<%=id %>" method="post">
   <table style="with: 100%">
 <tr>
     <td><input type="text" required name="username" value="<%=user.getClientInfo(id).getLogin()  %>" /></td>
    </tr>
    <tr>
     <td><input type="password" required name="password" value="<%= user.getClientInfo(id).getPassword() %>" /></td>
 </tr>
 <tr>
     <td><input type="text" required name="ville" value="<%= user.getClientInfo(id).getVille()  %>"/></td>
    </tr>
    <tr>
     <td><input type="text" required name="email" value="<%= user.getClientInfo(id).getEmail()%>" /></td>
 </tr>
   </table>
   <input class="btn" type="submit" value="Update" /><br />
     
   
  </form>
 </div>
</body>
</html>