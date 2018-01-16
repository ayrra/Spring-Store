package com.yrra.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.yrra.bookstore.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
