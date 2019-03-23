package com.hhu.dc.repository;

import com.hhu.dc.domain.HotCake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotCakeRepository extends JpaRepository<HotCake, Integer> {

    @Query(nativeQuery = true, value = "select menu_id as id ,name,sum(item.count) as num from order_item item,menu m where m.id = item.menu_id group by menu_id order by sum(item.count) DESC limit 3")
    List<HotCake> findTop();
}
