package fr.acceis.forum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="FilDiscussion_id")
	private FilDiscussion thread;
	@Column(name="auteur")
	private String auteur;
	@Column(name="creation")
	private Date creation;
	@Column(name="contenu")
	private String contenu;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public FilDiscussion getThread() {
		return thread;
	}
	
	public void setThread(FilDiscussion thread) {
		this.thread = thread;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public Date getCreation() {
		return creation;
	}
	
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	
	public String getContenu() {
		return contenu;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}
