package com.yrra.bookstore.service;

import com.yrra.bookstore.domain.BillingAddress;
import com.yrra.bookstore.domain.Order;
import com.yrra.bookstore.domain.Payment;
import com.yrra.bookstore.domain.ShippingAddress;
import com.yrra.bookstore.domain.ShoppingCart;
import com.yrra.bookstore.domain.User;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user);
	
	Order findOne(long id);

}
