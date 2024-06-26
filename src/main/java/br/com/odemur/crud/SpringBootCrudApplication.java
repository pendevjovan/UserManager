package br.com.odemur.crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.odemur.crud.domain.User;
import br.com.odemur.crud.repository.UserRepository;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	/*
	 * This is a command line runner which will automatically read JSON file, and
	 * write to DB
	 */
	@Bean
	CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream, typeReference);
				userRepository.saveAll(users);
				System.out.println("Users data successfully saved!");
			} catch (IOException e) {
				System.out.println("Unable to save users data: " + e.getMessage());
			}
		};
	}

}
