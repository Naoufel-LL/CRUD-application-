package web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import metier.Registre;
import metier.User;
/**
 * Servlet implementation class RegistreServlet
 */

public class RegistreServlet extends HttpServlet {
	static int a =2;
	static int b=0;

	private static final long serialVersionUID = 1L;
	public Registre r ;
	public void  init() {
		 r = new Registre();

	} 
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ville = request.getParameter("ville");
        String email = request.getParameter("email");

       
        User u = new User();
        a+=1;
        Random rand = new Random();
        int id = 1 + rand.nextInt(9);
        for(int i=0;i<5;i++){
            id *= 10L;
            id += rand.nextInt(10);
        }
        u.setLogin(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setVille(ville);
        u.setId(id);
        
        try {
			b=r.registre(u);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			response.sendRedirect("users?ville=");
	}

}
