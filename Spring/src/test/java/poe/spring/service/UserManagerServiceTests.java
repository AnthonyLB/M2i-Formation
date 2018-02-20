package poe.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserManagerServiceTests {

	@Autowired
	UserManagerService userManagerService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void checkUserCreation() {
		assertThat("toto").isEqualTo("toto");
		
		//Enregistre un utilisateur en BDD
		String login = "bob";
		String pwd = "bob";		
		User createdUser = userManagerService.signup(login,pwd);
		
		//Recupere l'utilisateur precedement cree fen BDD
		long createdUserId = createdUser.getId();
		User user = userRepository.findOne(createdUserId);
		
		//Verification
		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
	}
}
