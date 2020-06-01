package com.aaa.biz.impl;

import com.aaa.biz.UserInfoBiz;
import com.aaa.dao.MyUserInfoMapper;
import com.aaa.entity.MyUserInfo;
import com.aaa.shiro.ShiroUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserInfoBizImpl implements UserInfoBiz {
    @Autowired
    private MyUserInfoMapper myUserInfoMapper;

    @Override
    public PageInfo<MyUserInfo> selectAllUser(int page,int limit) {

        PageHelper.startPage(page,limit);
        List<MyUserInfo> myUserInfos = myUserInfoMapper.selectAllUser();

        PageInfo<MyUserInfo> pageInfo = new PageInfo(myUserInfos);
        return pageInfo;

    }


    @Override
    public MyUserInfo selectUserByUsername(String username) {
        return myUserInfoMapper.selectUserByUsername(username);
    }

    @Override
    public int insertSelective(MyUserInfo record) {

        String salt= UUID.randomUUID().toString();
        String message=record.getPassword();
        String encryption = ShiroUtil.encryptionBySalt(salt, message);
        record.setPassword(encryption);
        record.setSalt(salt);
        return myUserInfoMapper.insertSelective(record);
    }

    @Override
    public int delUserByID(List<String> ids) {
        return myUserInfoMapper.delUserByID( ids) ;
    }

    @Override
    public int updateByPrimaryKeySelective(MyUserInfo record) {
        return myUserInfoMapper.updateByPrimaryKeySelective(record);
    }
}
