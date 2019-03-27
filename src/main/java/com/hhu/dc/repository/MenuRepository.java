package com.hhu.dc.repository;

import com.hhu.dc.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Array;
import java.util.List;
import java.util.Map;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // 按名字模糊搜索
    @Query(value = "select m from Menu m where m.name like %:name%")
    List<Menu> findByNameLike(@Param("name") String name);

    // 按分类搜索
    List<Menu> findMenusByCategory(@Param("category") String category);

    // 获取全部
    List<Menu> findAll();

    // 按id删除商品
    void deleteById(@Param("id") Integer id);

    // 获取所有分类
    @Query(value = "select distinct category from Menu m")
    List<Menu> findCategory();

    // 获取热销榜
    @Query(value = "select m.id as id, m.name as name, sum(i.count) as num from Menu m, OrderItem i where m.id = i.menuId group by m.id order by sum(i.count) DESC ")
    List<Map> findTop();
}
