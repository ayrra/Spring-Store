package com.yrra.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.yrra.bookstore.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
