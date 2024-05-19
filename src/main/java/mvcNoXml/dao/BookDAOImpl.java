package mvcNoXml.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mvcNoXml.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(book);
	}

	@Override
	public Book get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = sessionFactory.getCurrentSession().createQuery("from Book", Book.class).list();
		return books;
	}

	@Override
	public void update(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(book);
	}

	@Override
	public String delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		if (book!=null) {
			entityManager.remove(book);
			return String.format("%s deleted successFully", book.getName());
		}
		else {
			return "Book not found";
		}
	}

}
