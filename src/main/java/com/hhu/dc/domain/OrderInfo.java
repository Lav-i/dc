package com.hhu.dc.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;
import java.util.List;

@Entity
public class OrderInfo {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer tableId;

    private Date createTime;

    private Integer state;

    @Transient
    private List<OrderItem> data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public OrderInfo() {

    }

    public List<OrderItem> getData() {
        return data;
    }

    public void setData(List<OrderItem> data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

}
