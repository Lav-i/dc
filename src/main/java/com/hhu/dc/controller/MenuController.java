package com.hhu.dc.controller;

import com.hhu.dc.domain.Menu;
import com.hhu.dc.domain.Result;
import com.hhu.dc.service.MenuService;
import com.hhu.dc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "")
    public Result findAll() {
        return menuService.findAll();
    }

    @GetMapping(value = "/category")
    public Result findBycategory(@RequestParam("category") String category) {
        return menuService.findByCategory(category);
    }

    @GetMapping(value = "/name")
    public Result findByNameLike(@RequestParam("name") String name) {
        return menuService.findByNameLike(name);
    }

    @GetMapping(value = "/hotcake")
    public Result hotCake() {
        return menuService.findHotCake();
    }

    @PostMapping(value = "/delete")
    public Result deleteById(@RequestBody Map<String, String> map) {
        return menuService.deleteById(Integer.parseInt(map.get("id")));
    }

    @PostMapping(value = "/update")
    public Result updateMenu(@RequestBody Menu menu) {
        return menuService.updateMenu(menu);
    }

    @GetMapping(value = "/getcategory")
    public Result findCategory() {
        return menuService.findCategory();
    }

    @GetMapping(value = "/init")
    public Result init() {
        return menuService.init();
    }
}