package com.hhu.dc.repository;

import com.hhu.dc.domain.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {

    // 按id删除
    void deleteById(@Param("id") Integer id);

}
