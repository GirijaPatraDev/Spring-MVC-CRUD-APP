package mvcNoXml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mvcNoXml.dao.BookDAO;
import mvcNoXml.model.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDAO bookDao;

	@Override
	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	@Transactional
	public Book get(Long id) {
		return bookDao.get(id);
	}

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	@Override
	@Transactional
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	@Transactional
	public String delete(Long id) {
		return bookDao.delete(id);
	}
	

}
