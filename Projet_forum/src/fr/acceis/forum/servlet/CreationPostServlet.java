package fr.acceis.forum.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.model.FilDiscussion;
import fr.acceis.forum.model.Post;
import fr.acceis.forum.services.FilDiscussionService;
import fr.acceis.forum.services.PostService;

public class CreationPostServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/jsp/creation_post.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String contenu = req.getParameter("contenu");
		String auteur = (String) session.getAttribute("name");
		long idFil = Long.parseLong(req.getParameter("id"));
		Post post = new Post();
		FilDiscussionService discussionService = new FilDiscussionService();
		FilDiscussion thread = discussionService.getById(idFil);
		
		post.setAuteur(auteur);
		post.setContenu(contenu);
		post.setThread(thread);
		post.setCreation(new Date());
		thread.getPosts().add(post);
		PostService postService = new PostService();
		
		postService.ajouterPost(post);
		resp.sendRedirect("http://localhost:8080/forum/thread?id=" + idFil);
	}
}
