package com.yakupselami.spring6webapp.bootstrap;


import com.yakupselami.spring6webapp.domain.Author;
import com.yakupselami.spring6webapp.domain.Book;
import com.yakupselami.spring6webapp.domain.Publisher;
import com.yakupselami.spring6webapp.repositories.AuthorRepository;
import com.yakupselami.spring6webapp.repositories.BookRepository;
import com.yakupselami.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("56769865");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Penguin Random House");
        publisher1.setAddress("ABD");
        publisher1.setCity("New York");
        publisher1.setState("New York City");
        publisher1.setZipCode("10019");

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Macmillian Publishers");
        publisher2.setAddress("ABD");
        publisher2.setCity("New York");
        publisher2.setState("New York City");
        publisher2.setZipCode("RG21 6XS");

        Publisher savedPublisher = publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
    }
}
