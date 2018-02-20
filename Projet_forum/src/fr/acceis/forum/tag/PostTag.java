package fr.acceis.forum.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import fr.acceis.forum.model.FilDiscussion;
import fr.acceis.forum.model.Post;
import fr.acceis.forum.services.FilDiscussionService;
import fr.acceis.forum.services.PostService;

public class PostTag extends SimpleTagSupport{

private long idFilDiscussion;
	
	public void setIdFilDiscussion(long id) {
	 this.idFilDiscussion = id;	
	}
	
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		String html = "";
		
		PostService postService = new PostService();
		FilDiscussionService topicService = new FilDiscussionService();
		FilDiscussion topic = topicService.getById(idFilDiscussion);
		topic.setNbVue(topic.getNbVue()+1);
		topicService.update(topic);
		List<Post> posts = postService.getPosts(idFilDiscussion);
		int nbPost = posts.size();
		
		if(posts != null) {
			for(Post it: posts) {
				html += "<tbody>"
						+ "<tr class=\"row2\">"
						+ "<td valign=\"middle\" align=\"center\"><b class=\"postauthor\">"+ it.getAuteur() + "</b>"
						+ "</td>"
						+ " <td width=\"100%\" height=\"25\">"
						+ "<table cellspacing=\"0\" width=\"100%\">"
						+ "<tbody>"
						+ "<tr>"
						+ "<td class=\"gensmall\" width=\"100%\">"
						+ "<div style=\"float: left;\">&nbsp;"
						+ "<b>Fil de discussion :</b> "+ it.getThread().getTitre()
						+ "</div>"
						+ "<div style=\"float: right;\">"
						+ "<b>Posted:</b> Wed Aug 17, 2016 2:12 pm&nbsp;"
						+ "</div></td></tr></tbody></table></td></tr></tbody>";

				html += "<tr class=\"row2\">"
						+ "<td class=\"profile\" valign=\"top\">"
						+ "<table cellspacing=\"4\" align=\"center\" width=\"150\">"
						+ "</table> <span class=\"postdetails\"> <b>Posts:</b> "+ nbPost +"</span>"
						+ "</td>"
						+ "<td valign=\"top\">"
						+ "<table cellspacing=\"5\" width=\"100%\">"
						+ "<tbody>"
						+ "<tr>"
						+ "<td>"
						+ "<div class=\"postbody\">"+it.getContenu()+"</div>"
						+ "<br clear=\"all\" /><br />"
						+ "<table cellspacing=\"0\" width=\"100%\">"
						+ "<tbody>"
						+ "<tr valign=\"middle\">"
						+ "<td class=\"gensmall\" align=\"right\"></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
						+ "<tr><td class=\"spacer\" colspan=\"2\" height=\"1\"><img src=\"fichiers/spacer.gif\" alt=\"\" width=\"1\" height=\"1\" /></td></tr>";
			}	
		}
		out.println(html);
	}
}
