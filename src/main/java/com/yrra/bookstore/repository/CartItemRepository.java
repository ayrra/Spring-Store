package com.yrra.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yrra.bookstore.domain.CartItem;
import com.yrra.bookstore.domain.ShoppingCart;


public interface CartItemRepository extends CrudRepository<CartItem, Long>{

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
}
