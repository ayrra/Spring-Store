package com.yrra.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.yrra.bookstore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);
	
}
