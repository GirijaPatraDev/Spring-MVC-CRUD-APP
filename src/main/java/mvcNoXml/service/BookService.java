package mvcNoXml.service;

import java.util.List;

import mvcNoXml.model.Book;

public interface BookService {
	// save the record
	void save(Book book);
	
	// get single book record
	Book get(Long id);
		
	// get all books record
	List<Book> getAllBooks();
		
	// Update the record
	void update(Book book);
	
	// Delete the record
	String delete(Long id);
}
