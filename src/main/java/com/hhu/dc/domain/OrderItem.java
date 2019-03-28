package com.hhu.dc.domain;


import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer menuId;

    private Integer count;

    public OrderItem() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
