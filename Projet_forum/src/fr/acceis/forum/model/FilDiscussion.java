package fr.acceis.forum.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="FilDiscussion")
public class FilDiscussion {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="titre")
	private String titre;
	@Column(name="creation")
	private Date creation;
	@Column(name="auteur")
	private String auteur;
	@OneToMany(mappedBy="thread")
	private List<Post> posts;
	@Column(name="vue")
	private int nbVue;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Date getCreation() {
		return creation;
	}
	
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getNbVue() {
		return nbVue;
	}

	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
	}
}
