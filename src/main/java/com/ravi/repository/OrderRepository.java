package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
