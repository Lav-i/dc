package com.hhu.dc.controller;

import com.hhu.dc.domain.Result;
import com.hhu.dc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/category")
    public Result findBycategory(@RequestParam("category") String category) {
        return menuService.findByCategory(category);
    }

    @GetMapping(value = "/name")
    public Result findByNameLike(@RequestParam("name") String name) {
        return menuService.findByNameLike(name);
    }

    @GetMapping(value = "/init")
    public Result init() {
        return menuService.init();
    }

    @GetMapping(value = "/hotcake")
    public Result hotCake() {
        return menuService.findHotCake();
    }
}