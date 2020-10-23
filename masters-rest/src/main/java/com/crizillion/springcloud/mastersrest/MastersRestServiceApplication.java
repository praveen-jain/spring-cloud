package com.crizillion.springcloud.mastersrest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class MastersRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastersRestServiceApplication.class, args);
	}

	@Value("${num.users}")
	private int numUsers;

	@Bean
	public CommandLineRunner init(UserRepository userRepository){
		return strings -> IntStream.range(0,numUsers).forEach(u -> {
			User user = new User();
			user.setUserName("user"+u);
			LoggerFactory.getLogger(getClass()).info("Created User : {}",u);
			userRepository.save(user);
		});
	}

}
