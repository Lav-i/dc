package com.hhu.dc.controller;

import com.hhu.dc.domain.OrderInfo;
import com.hhu.dc.domain.Result;
import com.hhu.dc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/new")
    public Result newOrder(@RequestBody OrderInfo orderInfo) {

        orderInfo.setCreateTime(new Date(System.currentTimeMillis()));
        return orderService.newOrder(orderInfo);
    }

}
