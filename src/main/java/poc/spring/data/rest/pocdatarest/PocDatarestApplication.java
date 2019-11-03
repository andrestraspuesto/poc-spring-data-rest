package poc.spring.data.rest.pocdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;


@SpringBootApplication
public class PocDatarestApplication {
	
	
	 @Bean
	 public ResourceBundleMessageSource messageSource() {
	  ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	  source.setBasenames("i18n/messages");  // name of the resource bundle 
	  source.setUseCodeAsDefaultMessage(true);
	  return source;
	 }
	 	
	public static void main(String[] args) {
		SpringApplication.run(PocDatarestApplication.class, args);
	}

}
