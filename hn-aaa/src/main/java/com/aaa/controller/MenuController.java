package com.aaa.controller;

import com.aaa.biz.MenuBiz;
import com.aaa.entity.LayUiTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuBiz menuBiz;
    @RequestMapping("/toShowMenu")
    public String toShowMenu() {
        return "menu/showMenu";
    }
    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public List<LayUiTree> selectAllMenu(){
        List<LayUiTree> layUiTrees = menuBiz.selectAllMenu();
        return layUiTrees;
    }
}
