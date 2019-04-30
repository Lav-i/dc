package com.hhu.dc.service;

import com.hhu.dc.domain.OrderInfo;
import com.hhu.dc.domain.OrderItem;
import com.hhu.dc.domain.Result;
import com.hhu.dc.repository.OrderInfoRepository;
import com.hhu.dc.repository.OrderItemRepository;
import com.hhu.dc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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

    public Result deleteById(Integer id) {
        orderInfoRepository.deleteById(id);
        return ResultUtil.success();
    }

    public Result findByMonth(Integer months) {
        List<Map> result = new ArrayList<>();
        for (; months >= 0; months--) {
            List<OrderInfo> list = orderInfoRepository.findByMonth(months);
            Double price = 0.;
            for (int i = 0; i < list.size(); i++) {
                price += list.get(i).getPrice();
            }
            Map<String, Double> map = new HashMap<>();
            map.put("price", price);
            map.put("monthBefore", new Double(months));
            result.add(map);
        }
        return ResultUtil.success(result);
    }

    public Result topItem(Integer days) {
        return ResultUtil.success(orderItemRepository.topItem(days));
    }

}
