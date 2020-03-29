package guru.springframework.spring5webapp.bookstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public BootStrapData(BookRepository bookRepository,
      AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "3933339593");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books " + bookRepository.count());
  }
}
