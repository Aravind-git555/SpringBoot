package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Books;
import com.example.demo.Service.BookService;

@RestController
public class BooksController {

	@Autowired
	BookService service;

	@GetMapping("/all")
	public List<Books> getAllBooks() {
		return service.getAll();
	}

	@GetMapping("/select/{id}")
	public Books getBooksById(@PathVariable int id) {
		return service.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@PostMapping("/create")
	public String create(@RequestBody Books books) {
		service.saveBook(books);
		return "success";
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Books books) {
		service.saveBook(books);
		return "Updated";
	}

}
