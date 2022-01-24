package com.imodupsy.shawamacloud.repository;

import com.imodupsy.shawamacloud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author iModupsy
 * @created 24/01/2022
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByZip(String zip);

   /* @Query("Order o where o.deliveryCity='Seattle'")
    List<TacoOrder> readOrdersDeliveredInSeattle(); */
}
