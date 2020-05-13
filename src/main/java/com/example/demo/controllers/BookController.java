package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;


@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books",bookRepository.findAll());
		List<Book> booklist= (List<Book>) bookRepository.findAll();
		System.out.println(booklist);
		return "bookslist";
	}

}
