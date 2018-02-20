package fr.acceis.forum.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import fr.acceis.forum.model.FilDiscussion;
import fr.acceis.forum.services.FilDiscussionService;

public class DiscussionsTag extends SimpleTagSupport {
	
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		FilDiscussionService filDiscService = new FilDiscussionService();
		List<FilDiscussion> filDiscussions = filDiscService.getDiscussions();
		
		if (filDiscussions != null) {
			String text = "";
			for(FilDiscussion it: filDiscussions) {
				if(it!=null) {
				
				text += "<tr>\r\n" + 
						"<td class=\"row1\"><a class=\"topictitle\" href=\"thread?id="+ it.getId() +"\" >" +  it.getTitre() +"</a></td>\r\n" + 
						"<td class=\"row2\" align=\"center\" width=\"130\"><p class=\"topicauthor\"><a class=\"username-coloured\" href=\"#\">"+ it.getAuteur() +"</a></p></td>\r\n" + 
						"<td class=\"row1\" align=\"center\" width=\"50\"><p class=\"topicdetails\">"+ it.getPosts().size() +"</p></td>\r\n" + 
						"<td class=\"row2\" align=\"center\" width=\"50\"><p class=\"topicdetails\">"+ it.getNbVue() +"</p></td>\r\n" + 
						"</tr>\n";
				}
			}
			out.println(text);
		}
	}
}
