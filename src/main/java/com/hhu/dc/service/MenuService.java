package com.hhu.dc.service;

import com.hhu.dc.domain.Menu;
import com.hhu.dc.domain.Result;
import com.hhu.dc.repository.MenuRepository;
import com.hhu.dc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Result findByNameLike(String name) {
        return ResultUtil.success(menuRepository.findByNameLike(name));
    }

    public Result findAll() {
        return ResultUtil.success(menuRepository.findAll());
    }

    public Result findByCategory(String name) {
        if (name.equals("所有")) {
            return ResultUtil.success(menuRepository.findAll());
        } else {
            return ResultUtil.success(menuRepository.findMenusByCategory(name));
        }
    }

    public Result findHotCake() {
        return ResultUtil.success(menuRepository.findTop().subList(0, 3));
    }

    public Result deleteById(Integer id) {
        menuRepository.deleteById(id);
        return ResultUtil.success();
    }

    public Result updateMenu(Menu menu) {
        return ResultUtil.success(menuRepository.save(menu));
    }

    public Result findCategory() {
        return ResultUtil.success(menuRepository.findCategory());
    }

    public Result newMenu(Menu menu) {
        return ResultUtil.success(menuRepository.save(menu));
    }

}
