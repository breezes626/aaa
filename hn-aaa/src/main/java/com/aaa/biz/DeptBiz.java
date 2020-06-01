package com.aaa.biz;

import com.aaa.entity.Dept;
import com.aaa.entity.Role;
import com.aaa.entity.User;

import java.util.List;


public interface DeptBiz {
    List<Dept> selectAllDept();

    int insertSelective(Dept record);

    int updateByPrimaryKeySelective(Dept record);

    int delDeptByID(List<String> ids);

    List<Dept> selectByDept(String deptName);
}
