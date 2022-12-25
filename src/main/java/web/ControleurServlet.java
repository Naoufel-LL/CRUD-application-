package web;
import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.User;
import metier.UserImpl;

@WebServlet("/r")
public class ControleurServlet extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private UserImpl users;
@Override
public void init() throws ServletException {  
users=new UserImpl();
}
@Override
protected void doGet(HttpServletRequest request,  HttpServletResponse response)
throws ServletException, IOException {  
UserModele moduser=new UserModele();  
moduser.setVille(request.getParameter("ville"));
List<User> liste_users=users.getClientsParV(moduser.getVille()); 
moduser.setUsers(liste_users);
request.setAttribute("modele", moduser);
request.getRequestDispatcher("usersView.jsp").forward(request,  response);
} 

@Override
protected void doPost(HttpServletRequest request,  HttpServletResponse response)
throws ServletException, IOException {  
UserModele moduser=new UserModele();  
moduser.setVille(request.getParameter("ville"));
List<User> liste_users=users.getClientsParV(moduser.getVille()); 
moduser.setUsers(liste_users);
request.setAttribute("modele", moduser);
request.getRequestDispatcher("usersView.jsp").forward(request,  response);
} 
}

