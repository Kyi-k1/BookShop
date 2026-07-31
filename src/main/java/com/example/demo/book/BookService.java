package com.example.demo.book;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	
	public List<Book> listAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book findBookById(long id) {
		return bookRepository.findById(id).get();
	}
}
