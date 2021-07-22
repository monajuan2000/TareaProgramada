package proyecto.sismoit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMailApplication.class, args);
	}

}
