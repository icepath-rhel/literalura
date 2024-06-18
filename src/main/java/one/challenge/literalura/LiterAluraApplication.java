package one.challenge.literalura;

import one.challenge.literalura.main.Main;
import one.challenge.literalura.repository.BooksRepository;
import one.challenge.literalura.service.ProjectGutenberg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private ProjectGutenberg projectGutenberg;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(booksRepository, projectGutenberg);
		main.execute();
	}
}
