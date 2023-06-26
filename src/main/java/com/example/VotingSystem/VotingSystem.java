package com.example.VotingSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.VotingSystem.model.User;
import com.example.VotingSystem.repository.UserRepository;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class VotingSystem {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystem.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository) {
		// this function will run when the application starts.
		return runner -> {
			// insert user to database.
			// User user = new User("admin", "admin", "admin@admin", "admin");
			// userRepository.save(user);

		};
	}
}
