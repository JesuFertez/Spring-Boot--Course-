package com.example.springbootcourse.bootstrap;

import com.example.springbootcourse.model.Author;
import com.example.springbootcourse.model.Book;
import com.example.springbootcourse.model.Publisher;
import com.example.springbootcourse.repositories.AuthorRepository;
import com.example.springbootcourse.repositories.BookRepository;
import com.example.springbootcourse.repositories.PublisherReposotory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherReposotory publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherReposotory publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Erick", "Evans");
        Book book = new Book("lala","123123");

        Publisher publisher = new Publisher();
        publisher.setName("T&T Publishing");
        publisher.setCity("Santiago");
        publisher.setState("Costanera");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);


        System.out.println("Started in Boostrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
