package com.yrra.bookstore.service;

import com.yrra.bookstore.domain.Payment;
import com.yrra.bookstore.domain.UserPayment;

public interface PaymentService {

	Payment setByUserPayment(UserPayment userPayment, Payment payment);

}
