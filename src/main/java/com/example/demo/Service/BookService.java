package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Books;
import com.example.demo.repository.BooksRepository;

@Service
public class BookService {

	@Autowired
	BooksRepository repository;

	// FindAll
	public List<Books> getAll() {
		List<Books> list = new ArrayList<Books>();
		list = (List<Books>) repository.findAll();
		return list;
	}

	// FindById
	public Books findById(int id) {

		Optional<Books> book = repository.findById(id);
		return book.get();
	}

	// Save
	public void saveBook(Books books) {
		repository.save(books);
	}

	// Delete
	public void delete(int id) {
		repository.deleteById(id);
	}

	// Update
	public void update(Books book, int id) {
		repository.save(book);
	}

}
