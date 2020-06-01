package com.aaa.biz.impl;

import com.aaa.biz.RoleBiz;
import com.aaa.dao.RoleMapper;
import com.aaa.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleBizImpl implements RoleBiz {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }
}
