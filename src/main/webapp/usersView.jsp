<%@page import="metier.User"%><%@page import="java.util.List"%>
<%@page import="web.UserModele"%>
<%
UserModele mod;  
if(request.getAttribute("modele")!=null){
mod=(UserModele)request.getAttribute("modele");
}
else{ mod=new UserModele(); };


%>
<%
  if(mod.getVille() == null){
	  mod.setVille("");
  };
%>
<html>
<style>
body{
   font-family:sans-serif;
   display:flex;justify-content:center;align-items:center;flex-direction:column;padding-top:5%;
}
.btn { background-color: #13ab52; border: 1px solid #13aa52; border-radius: 4px; box-shadow: rgba(0, 0, 0, .1) 0 2px 4px 0; box-sizing: border-box; color: #fff; cursor: pointer; font-family: "Akzidenz Grotesk BQ Medium", -apple-system, BlinkMacSystemFont, sans-serif; font-size: 16px; font-weight: 400; outline: none; outline: 0; padding: 10px 25px; text-align: center; transform: translateY(0); transition: transform 150ms, box-shadow 150ms; user-select: none; -webkit-user-select: none; touch-action: manipulation; }
.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
td a{
   padding-left:15px;
 }
 td a img{
  width : 30px;
 }
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table  tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table  tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table  tr:last-of-type {
    border-bottom: 2px solid #009879;
}
</style>
<body>
<form action="users" method="get">
Ville:<input type="text" name="ville" value="<%=mod.getVille() %>">
<input type="submit" class="btn" value="Chercher">
</form>
<table class="styled-table" border="1" width="80%">
<tr>
<thead>
        <tr>
           <th>ID</th><th>LOGIN</th><th>EMAIL</th><th>VILLE</th><th>Action</th>

        </tr>
    </thead>
</tr>
<%
List<User> users=mod.getUsers();  
for(User u:users){%>
<tr>
<td><%=u.getId() %></td> <td><%=u.getLogin() %></td>
<td><%=u.getEmail() %></td> <td><%=u.getVille() %></td><td><a href="<%=request.getContextPath()%>/update.jsp?id=<%= u.getId() %>"><img alt="" src="edit.png"></a><a href="<%=request.getContextPath()%>/delete.jsp?id=<%= u.getId() %>"><img alt="" src="delete.png"></a></td>
</tr>
<% } %>
</table></body></html>
