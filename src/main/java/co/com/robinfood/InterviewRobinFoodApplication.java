package co.com.robinfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "co.com.robinfood.adapter", "co.com.robinfood.domain", "co.com.robinfood.util" })
@EnableJpaRepositories("co.com.robinfood.domain.repository")
@EntityScan({ "co.com.robinfood.domain.entity" })
public class InterviewRobinFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewRobinFoodApplication.class, args);
	}

}
