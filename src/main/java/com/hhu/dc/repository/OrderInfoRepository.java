package com.hhu.dc.repository;

import com.hhu.dc.domain.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {

    // 按id删除
    void deleteById(@Param("id") Integer id);

    // 获取最近monthBefore个月的销售业绩
    @Query(nativeQuery = true, value = "select * from order_info where PERIOD_DIFF(date_format(now(),'%Y%m'),date_format(create_time,'%Y%m'))=:monthBefore")
    List<OrderInfo> findByMonth(@Param("monthBefore") Integer monthBefore);

}
