package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import fr.acceis.forum.services.UtilisateurService;

public class LoginServlet extends HttpServlet{

	private UtilisateurService loginService;
	
	//Demande de donnee statique au serveur
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("isLogged", false);
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
	//Demande de processus au serveur
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String login = req.getParameter("username");
		String pwd = req.getParameter("password");
		loginService = new UtilisateurService();
		boolean isOk = loginService.isAuthentificationOk(login, pwd);
		
		if ( isOk ) {
			session.setAttribute("name", login);
			session.setAttribute("isLogged", true);
			resp.sendRedirect("http://localhost:8080/forum/home");
		} else {
			session.removeAttribute("name");
			session.setAttribute("isLogged", false);
			resp.sendRedirect("http://localhost:8080/forum/login");
		}
	}
}
