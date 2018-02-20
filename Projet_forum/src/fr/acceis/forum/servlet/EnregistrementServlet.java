package fr.acceis.forum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.model.Utilisateur;
import fr.acceis.forum.services.UtilisateurService;

public class EnregistrementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/enregistrement.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		Utilisateur user = new Utilisateur();
		user.setLogin(username);
		user.setInscription(new Date());
		user.setPassword(password);
		user.setEmail(email);
		
		UtilisateurService userService = new UtilisateurService();
		userService.ajouterUtilisateur(user);
		
		session.setAttribute("name", username);
		session.setAttribute("isLogged", true);
		
		resp.sendRedirect("http://localhost:8080/forum/home");
	}
}
