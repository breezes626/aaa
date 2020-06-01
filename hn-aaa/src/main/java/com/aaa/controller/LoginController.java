package com.aaa.controller;

import com.aaa.biz.MenuBiz;
import com.aaa.entity.LayUiTree;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private MenuBiz menuBiz;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        System.out.println(username+password);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token= new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("message","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
            return "login";
        }

        model.addAttribute("loginName",username);

        List<LayUiTree> menus = menuBiz.selectAllMenuByName(username);
        model.addAttribute("menus",menus);
        return "index";
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
