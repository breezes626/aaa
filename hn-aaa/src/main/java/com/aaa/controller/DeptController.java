package com.aaa.controller;

import com.aaa.biz.DeptBiz;
import com.aaa.biz.impl.DeptBizImpl;
import com.aaa.entity.Dept;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.MyUserInfo;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptBiz deptBizImpl;

    @RequestMapping("/toShowDept")
    public String toShowDept() {
        return "dept/showDept";
    }

    @RequestMapping("/showDept")
    @ResponseBody
    public LayUiTable showDept() {

        List<Dept> deptList = deptBizImpl.selectAllDept();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(deptList);
        return layUiTable;
    }


    @RequestMapping("/saveDept")
    @ResponseBody
    public Object saveDept(Dept dept) {
        int i = deptBizImpl.insertSelective(dept);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.saveSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.saveFailMsg);
        }
        return map;
    }


    @RequestMapping("/editDept")
    @ResponseBody
    public Object editDept(Dept dept) {
        int i = deptBizImpl.updateByPrimaryKeySelective(dept);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.editSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.editFailMsg);
        }
        return map;
    }


    @RequestMapping("/delDept")
    @ResponseBody
    public Object delUser(@RequestParam(value = "ids") String ids) {

        List<String> list = (List<String>) JSON.parse(ids);
        int i = deptBizImpl.delDeptByID(list);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.delSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.delFailMsg);
        }
        return map;
    }

    @RequestMapping("/selectDept")
    @ResponseBody
    public LayUiTable selectDeptByDeptName(String deptName) {

        List<Dept> deptList = deptBizImpl.selectByDept(deptName);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setData(deptList);
        return layUiTable;
    }
}
