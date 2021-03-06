package fr.acceis.forum.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue
	private long id;
	private String login;
	private String password;
	private String email;
	private Date inscription;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getInscription() {
		return inscription;
	}
	
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}	
}
