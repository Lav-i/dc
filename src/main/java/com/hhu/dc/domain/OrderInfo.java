package com.hhu.dc.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class OrderInfo {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer tableId;

    private Date createTime;

    private String state;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderItem> data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

    public Double getPrice() {
        Double price = 0.;
        for (int i = 0; i < this.data.size(); i++) {
            price += this.data.get(i).getCount() * this.data.get(i).getPrice();
        }
        return price;
    }

    public Boolean isDone() {
        for (int i = 0; i < this.data.size(); i++) {
            if (!this.data.get(i).getFinish())
                return false;
        }
        return true;
    }

}
