package br.com.odemur.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.odemur.crud.domain.User;
import br.com.odemur.crud.repository.UserRepository;

/**
 * JUnit Test Class
 * 
 * @author Odemur Marangoni
 * @version 1.0
 *
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class SpringBootCrudApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	@DisplayName("JUnit Test to get all users.")
	public void getAllUsersTest() {
		assertEquals(userRepository.findAll(), new ArrayList<>());
	}

	@Test
	@DisplayName("JUnit Test to get user by id.")
	public void getUserByIdTest() {

		User user = getUser();

		User result = userRepository.save(user);
		Assertions.assertThat(result.getFirstName()).isEqualTo("John");

	}

	@Test
	@DisplayName("JUnit Test to add user.")
	public void addUserTest() {

		User user = getUser();
		userRepository.save(user);

		List<User> result = new ArrayList<>();
		userRepository.findAll().forEach(e -> result.add(e));
		assertEquals(result.size(), 1);

	}

	private User getUser() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@mail.com");
		return user;
	}

}
