package com.yrra.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.yrra.bookstore.domain.BookToCartItem;

public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {

}
