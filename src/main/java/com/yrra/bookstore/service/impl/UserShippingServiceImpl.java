package com.yrra.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrra.bookstore.domain.UserShipping;
import com.yrra.bookstore.repository.UserShippingRepository;
import com.yrra.bookstore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService {

	@Autowired
	private UserShippingRepository userShippingRepository;
	
	@Override
	public UserShipping findById(long id) {
		return userShippingRepository.findOne(id);
	}

	@Override
	public void removeById(Long userShippingId) {
		userShippingRepository.delete(userShippingId);
		
	}

}
