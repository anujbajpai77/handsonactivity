package com.ibm.activity.ordersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.activity.ordersservice.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
