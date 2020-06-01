package com.aaa.biz;

import com.aaa.entity.MyUserInfo;
import com.aaa.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserBiz {

    PageInfo<User> selectAllUser(int page, int limit);
    User selectUserByUsername(String username);
    int insertSelective(User record);
    int delUserByID(List<String> ids);
    int updateByPrimaryKeySelective(User record);
}
