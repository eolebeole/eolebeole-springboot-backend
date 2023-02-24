package eolebeole.bemealmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BemealmapApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BemealmapApplication.class, args);
		System.out.println("http://localhost:" + context.getEnvironment().getProperty("server.port"));
	}

}
