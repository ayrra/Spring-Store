package com.yrra.bookstore.service;

import com.yrra.bookstore.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(long id);

	void removeById(Long userShippingId);
}
