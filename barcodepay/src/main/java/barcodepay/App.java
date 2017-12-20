package barcodepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App {

	@RequestMapping("/eews/*")
	String home() {
		return "HELLO MAN!";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
