package com.aaa.biz.impl;

import com.aaa.biz.MenuBiz;
import com.aaa.dao.MenuMapper;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuBizImpl implements MenuBiz {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }


    @Override
    public List<LayUiTree> selectAllMenu() {

        List<Menu> menus = menuMapper.selectAllMenu();

        return TreeUtils.getChildPerms(menus, 0);
    }

    @Override
    public List<LayUiTree> selectAllMenuByName(String loginName) {

        List<Menu> menus = menuMapper.selectAllMenuByName(loginName);

        return TreeUtils.getChildPerms(menus, 0);
    }
}
