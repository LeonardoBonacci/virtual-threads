package guru.bonacci.virtual.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ThreadsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ThreadsApplication.class, args);
	}


	@GetMapping("/id")
	public String getResponse() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		long threadId = Thread.currentThread().threadId();
		return String.valueOf(threadId);
	}

	@GetMapping("/name")
	public String getThreadName() {
		return Thread.currentThread().toString();
	}
}
