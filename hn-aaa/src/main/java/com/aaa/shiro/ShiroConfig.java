package com.aaa.shiro;

import com.aaa.util.MyConstants;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher());
        return myRealm;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager= new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        return defaultWebSecurityManager;
    }
    /**
     * shiroFilterFactorybean
     * shiro的安全过滤器，过滤所有的请求，对请求分类拦截
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());

        Map<String, String> map = new LinkedHashMap<>();

        map.put("/login","anon");

        map.put("/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return shiroFilterFactoryBean;
    }

    @Bean
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher= new HashedCredentialsMatcher();

        credentialsMatcher.setHashAlgorithmName(MyConstants.algorithmName);

        credentialsMatcher.setHashIterations(MyConstants.hashIterations);
        return credentialsMatcher;
    }
}
