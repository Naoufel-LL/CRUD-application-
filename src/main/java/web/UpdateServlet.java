package web;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import metier.SingletonConnection;
import metier.Update;
import metier.User;
/**
 * Servlet implementation class RegistreServlet
 */

public class UpdateServlet extends HttpServlet {
	static int a =2;
	static int b=0;

	private static final long serialVersionUID = 1L;
	public Update r ;
	public void  init() {
		 r = new Update();

	} 
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	
      }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ville = request.getParameter("ville");
        String email = request.getParameter("email");

       
        User u = new User();
        a+=1;
	    int id = Integer.parseInt(request.getParameter("id"));
        u.setLogin(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setVille(ville);
        u.setId(id);
        
        try {
			b=r.update(u);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			response.sendRedirect("users?ville=");
	}

}
