package com.yrra.bookstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrra.bookstore.domain.Book;
import com.yrra.bookstore.domain.CartItem;
import com.yrra.bookstore.domain.ShoppingCart;
import com.yrra.bookstore.domain.User;
import com.yrra.bookstore.service.BookService;
import com.yrra.bookstore.service.CartItemService;
import com.yrra.bookstore.service.ShoppingCartService;
import com.yrra.bookstore.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
		@Autowired
		private UserService userService;
	
		@Autowired
		private CartItemService cartItemService;
	
		@Autowired
		private ShoppingCartService shoppingCartService;
		
		@Autowired
		private BookService bookService;
	
		@RequestMapping("/cart")
		public String shoppingCart(Model model, Principal principal) {
			User user = userService.findByUsername(principal.getName());
			ShoppingCart shoppingCart = user.getShoppingCart();
			List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
	
			shoppingCartService.updateShoppingCart(shoppingCart);
	
			model.addAttribute("cartItemList", cartItemList);
			model.addAttribute("shoppingCart", shoppingCart);
	
			return "shoppingCart";
		}
		
		@RequestMapping("/addItem")
		public String addItem(@ModelAttribute("book") Book book, @ModelAttribute("qty") String qty, Model model, Principal principal) {
			User user = userService.findByUsername(principal.getName());
			book = bookService.findOne(book.getId());
			
			if (Integer.parseInt(qty) > book.getInStockNumber()) {
				model.addAttribute("notEnoughStock", true);
				return "forward:/bookDetails?id="+book.getId();
			}
			
			CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
			model.addAttribute("addBookSuccess", true);
			
			
			return "forward:/bookDetails?id="+book.getId();
		}
		
		@RequestMapping("/updateCartItem")
		public String updateCartItem(@ModelAttribute("id") Long cartItemId, @ModelAttribute("qty") int qty) {
			CartItem cartItem = cartItemService.findById(cartItemId);
			cartItem.setQty(qty);
			cartItemService.updateCartItem(cartItem);
			
			return "forward:/shoppingCart/cart";
			
		}
		
		@RequestMapping("/removeItem")
		public String removeItem(@RequestParam("id") Long id) {
			cartItemService.removeCartItem(cartItemService.findById(id));
			
			return "forward:/shoppingCart/cart";
		}
}
