package poe.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.aop.Chrono;
import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController{
	
	@Autowired
	UserManagerService userManagerService;
	
	@PostMapping("/save")
	@Chrono //Annotation precedement cree
	public User save(@RequestBody(required=true) User user) {
		User savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
		System.out.println("user id: " + savedUser);
		return savedUser;
	}
	
	@PostMapping("/delete")
	public User delete(@RequestBody(required=true) User user) {
		userManagerService.delete(user);
		System.out.println("user deleted id: " + user);
		return user;
	}
	
	@PostMapping("/exist")
	public boolean isExist(@RequestBody(required=true) User user) {
		return userManagerService.isExist(user.getLogin(), user.getPassword());
	}
	
	@PostMapping("/all")
	public Iterable<User> findAll(){
		return userManagerService.findAll();
	}
}
