package umc.jyuny_springprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JyunySpringprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(JyunySpringprjApplication.class, args);
	}

}
