package com.yrra.bookstore.service;

import java.util.List;

import com.yrra.bookstore.domain.Book;

public interface BookService {
	List<Book> findAll();

	Book findOne(Long id);
}
