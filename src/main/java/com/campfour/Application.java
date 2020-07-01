package com.campfour;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static final String APPLICATION_LOCATIONS =
			"classpath:application.yml," +
					"/Users/yj/Documents/dev/conf/campfour/application-local.yml";

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder(Application.class)
				.properties("spring.config.location=" +APPLICATION_LOCATIONS)
				.run(args);
	}

}
