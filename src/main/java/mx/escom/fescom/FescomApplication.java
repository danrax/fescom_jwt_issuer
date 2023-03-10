package mx.escom.fescom;

import mx.escom.fescom.config.FescomConfiguration;
import mx.escom.fescom.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({RsaKeyProperties.class, FescomConfiguration.class})
public class FescomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FescomApplication.class, args);
	}
}
