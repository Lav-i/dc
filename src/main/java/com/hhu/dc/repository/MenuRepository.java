package com.hhu.dc.repository;

import com.hhu.dc.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // 按名字模糊搜索
    @Query(value = "select m from Menu m where m.name like %:name%")
    List<Menu> findByNameLike(@Param("name") String name);

    // 按分类搜索
    List<Menu> findMenusByCategory(@Param("category") String category);

    // 获取全部
    List<Menu> findAll();

}
