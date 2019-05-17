package com.hhu.dc.repository;

import com.hhu.dc.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {


    @Query(nativeQuery = true, value = "select name,sum(count) as count from order_item where order_id in (select id from order_info where DATE_SUB(CURDATE(), INTERVAL :days DAY) <= create_time) group by name order by sum(count) DESC")
    List<Map> topItem(@Param("days") Integer days);

    OrderItem findOrderItemById(@Param("id") Integer id);;
}
