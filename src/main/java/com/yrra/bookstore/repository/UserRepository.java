package com.yrra.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.yrra.bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
