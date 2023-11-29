package com.randin.github.actions.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GithubActionsCiCdApplication {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to CICD GitHub Actions";
	}

	public static void main(String[] args) {
		SpringApplication.run(GithubActionsCiCdApplication.class, args);
	}

}
