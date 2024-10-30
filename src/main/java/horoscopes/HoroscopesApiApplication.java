package horoscopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HoroscopesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoroscopesApiApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/horoscopes").allowedOrigins("*");
			}
		};
	}
}
