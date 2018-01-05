package com.yrra.bookstore.service;

import com.yrra.bookstore.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);

	void removeById(Long creditCardId);
}
