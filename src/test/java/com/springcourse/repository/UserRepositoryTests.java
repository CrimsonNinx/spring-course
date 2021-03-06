package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 import com.springcourse.repository.UserRepositoryTests;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UserRepositoryTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void bsaveTest() {
		User user = new User(null, "Erick", "erickcostaferreira@outlook.com", "1234", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);

		assertThat(createdUser.getId()).isEqualTo(1L);
	}

	@Test
	public void updateTest() {
		User user = new User(1L, "Erick Costa", "erickcostaferreira@outlook.com", "1234", Role.ADMINISTRATOR, null,
				null);
		User updatedUser = userRepository.save(user);

		assertThat(updatedUser.getName()).isEqualTo("Erick Costa");

	}

	@Test
	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);
		User user = result.get();

		assertThat(user.getPassword()).isEqualTo("1234");

	}

	@Test
	public void listTest() {
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isEqualTo(1);
	}

	@Test
	public void loginTest() {
		Optional<User> result = userRepository.login("erickcostaferreira@outlook.com", "1234");
		User loggedUser = result.get();

		assertThat(loggedUser.getId()).isEqualTo(1L);

	}

}
