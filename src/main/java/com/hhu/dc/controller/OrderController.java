package com.hhu.dc.controller;

import com.hhu.dc.domain.OrderInfo;
import com.hhu.dc.domain.Result;
import com.hhu.dc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

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

    @PostMapping(value = "/delete")
    public Result deleteById(@RequestBody Map<String, String> map) {
        return orderService.deleteById(Integer.parseInt(map.get("id")));
    }

    @GetMapping(value = "")
    public Result findAll() {
        return orderService.findAll();
    }

    @GetMapping(value = "/callwaiter")
    public Result callWaiter() {
        return null;
    }

}
