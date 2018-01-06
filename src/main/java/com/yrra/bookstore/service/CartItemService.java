package com.yrra.bookstore.service;

import java.util.List;

import com.yrra.bookstore.domain.Book;
import com.yrra.bookstore.domain.CartItem;
import com.yrra.bookstore.domain.ShoppingCart;
import com.yrra.bookstore.domain.User;

public interface CartItemService {

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

	CartItem addBookToCartItem(Book book, User user, int qty);

}
