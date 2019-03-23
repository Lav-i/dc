package com.hhu.dc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HotCake {

    @Id
    private Integer id;

    private String name;

    private Integer num;

    public HotCake() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
