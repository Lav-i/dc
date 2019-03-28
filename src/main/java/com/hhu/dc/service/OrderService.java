package com.hhu.dc.service;

import com.hhu.dc.domain.OrderInfo;
import com.hhu.dc.domain.OrderItem;
import com.hhu.dc.domain.Result;
import com.hhu.dc.repository.OrderInfoRepository;
import com.hhu.dc.repository.OrderItemRepository;
import com.hhu.dc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Result newOrder(OrderInfo orderInfo) {
        List<OrderItem> data = orderInfo.getData();
        orderInfoRepository.save(orderInfo);
        for (OrderItem orderItem : data) {
            orderItemRepository.save(orderItem);
        }
        return ResultUtil.success();
    }

    public Result findAll() {
        return ResultUtil.success(orderInfoRepository.findAll());
    }

}
