package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookTest(BookRepository repository, CategoryRepository catrep) {
		return (args) -> {
			log.info("save a couple of books");

			Category cat1 = new Category("Fantasy");
			catrep.save(cat1);
			Category cat2 = new Category("Business");
			catrep.save(cat2);
			Category cat3 = new Category("Law");
			catrep.save(cat3);
			
			repository.save(new Book("Title", "Author", 2005, "ISBN", 10, cat1));

			repository.save(new Book("Art of code", "Antti Pori", 2011, "192.178.10.36", 101, cat2));
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
