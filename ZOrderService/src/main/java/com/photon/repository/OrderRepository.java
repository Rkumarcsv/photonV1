package com.photon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photon.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
