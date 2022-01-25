package com.imodupsy.shawamacloud.repository;

import com.imodupsy.shawamacloud.entity.OrderShawama;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iModupsy
 * @created 24/01/2022
 */
public interface OrderRepository extends JpaRepository<OrderShawama, Long> {

//    List<Order> findByZip(String zip);

   /* @Query("Order o where o.deliveryCity='Seattle'")
    List<TacoOrder> readOrdersDeliveredInSeattle(); */
}
