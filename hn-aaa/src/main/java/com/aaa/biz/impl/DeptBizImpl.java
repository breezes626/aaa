package com.aaa.biz.impl;

import com.aaa.biz.DeptBiz;
import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import com.aaa.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptBizImpl implements DeptBiz {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }

    @Override
    public  int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }


    @Override
    public int updateByPrimaryKeySelective(Dept record) {

        return deptMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int delDeptByID(List<String> ids) {
        return deptMapper.delDeptByID( ids) ;
    }

    @Override
    public List<Dept> selectByDept(String deptName) {
        return deptMapper.selectByDept(deptName);
    }

}
