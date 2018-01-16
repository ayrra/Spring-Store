package com.yrra.bookstore.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrra.bookstore.domain.BillingAddress;
import com.yrra.bookstore.domain.Book;
import com.yrra.bookstore.domain.CartItem;
import com.yrra.bookstore.domain.Order;
import com.yrra.bookstore.domain.Payment;
import com.yrra.bookstore.domain.ShippingAddress;
import com.yrra.bookstore.domain.ShoppingCart;
import com.yrra.bookstore.domain.User;
import com.yrra.bookstore.repository.OrderRepository;
import com.yrra.bookstore.service.CartItemService;
import com.yrra.bookstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Override
	public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			Book book = cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
		}
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
		
	}

	@Override
	public Order findOne(long id) {
		return orderRepository.findOne(id);
	}

}
