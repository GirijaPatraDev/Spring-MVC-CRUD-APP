package mvcNoXml.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mvcNoXml.model.Book;
import mvcNoXml.service.BookService;

@RestController
@RequestMapping("/book-api")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<?> getBooks() {
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok().body(books);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBook(@PathVariable(name = "id") Long id) {
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createBook(@Valid @RequestBody Book book) {
		bookService.save(book);
		return ResponseEntity.ok().body(String.format("%s saved successFully", book.getName()));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(name = "id") Long id) {
		String deleted = bookService.delete(id);
		return ResponseEntity.ok().body(deleted);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		bookService.update(book);
		return ResponseEntity.ok().body(String.format("%s updated successfully", book.getId()));
	}
}
