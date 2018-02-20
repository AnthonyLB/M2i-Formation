package poe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	public User signup(String login, String password) {

		User user = null;
		
		if(!isExist(login, password)) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			userRepository.save(user);
		}		

		return user;
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public boolean isExist(String login, String pwd) {
		
		boolean isExist = false;
//		System.out.println("isExit = " + isExist);
//		Iterable<User> users = userRepository.findAll();
//		System.out.println("loggin = " + login + ", pwd = " + pwd);
//		for(User it: users) {
//			System.out.println("loggin = " + it.getLogin() + ", pwd = " + it.getPassword());
//			if( it.getLogin().compareTo(login) == 0 && it.getPassword().compareTo(pwd) == 0) {
//				isExist = true;
//				System.out.println("isExit = " + isExist);
//			}
//		}
		if(userRepository.findByLogin(login)!=null) isExist=true;
		return isExist;		
	}
	
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
}