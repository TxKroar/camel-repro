package camel.repro.camelrepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import camel.repro.camelrepro.camel.ReproConfig;


@SpringBootApplication(scanBasePackageClasses = ReproConfig.class)
public class CamelReproApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CamelReproApplication.class, args);
	}
	
}
