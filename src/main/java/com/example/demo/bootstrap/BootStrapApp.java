package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

@Component
public class BootStrapApp implements CommandLineRunner{
	
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;

	public BootStrapApp(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Bootstrap App Started....");
		
		Publisher publisher = new Publisher();
		publisher.setName("MarMarSoe");
		publisher.setAddressLine1("AAAAAAAAAAAAa");
		publisher.setCity("Yangon");
		publisher.setState("Yangon");
		publisher.setZip("23456");
		
		publisherRepo.save(publisher);
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design", "234455");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepo.save(eric);
		bookRepo.save(ddd);
		
		Author rod =new Author("Rod", "John");
		Book j2ee = new Book("J2EE Development without EJB", "12345");
		rod.getBooks().add(j2ee);
		j2ee.getAuthors().add(rod);
		
		j2ee.setPublisher(publisher);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(j2ee);
		publisher.getBooks().add(ddd);
		
		authorRepo.save(rod);
		bookRepo.save(j2ee);
		publisherRepo.save(publisher);
		
		System.out.println("Number of book :" + bookRepo.count());

		System.out.println("Number of publisher :" + publisherRepo.count());
		
		System.out.println("Published number of books :" + publisher.getBooks().size());
	}

}
