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

public class CreationTopicServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.getRequestDispatcher("/WEB-INF/jsp/creation_topic.jsp").forward(req, resp);		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String title = req.getParameter("title");
		String post = req.getParameter("contenu");
		List<Post> posts = new ArrayList<Post>();
		Post firstPost = new Post();
		
		
		FilDiscussion discussion = new FilDiscussion();
		FilDiscussionService discussionService = new FilDiscussionService();
		PostService postService = new PostService();
		firstPost.setAuteur((String) session.getAttribute("name"));
		firstPost.setContenu(post);
		firstPost.setCreation(new Date());
		firstPost.setThread(discussion);
		posts.add(firstPost);
		
		discussion.setTitre(title);
		discussion.setAuteur((String) session.getAttribute("name"));
		discussion.setCreation(new Date());
		discussion.setPosts(posts);
		discussion.setNbVue(0);
		
		discussionService.ajouterDiscussion(discussion);
		postService.ajouterPost(firstPost);
		resp.sendRedirect("http://localhost:8080/forum/home");
	}
}
