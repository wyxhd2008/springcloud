///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: WebSecurityConfig
// * Author:   ywang7
// * Date:     2018/6/25 14:06
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.rick.framework.config;
//
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author ywang7
// * @create 2018/6/25
// * @since 1.0.0
// */
//@Configuration
//@EnableOAuth2Sso
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.logout();
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/index.html", "/", "/login").permitAll();
//        http.authorizeRequests().antMatchers("/secured/**").authenticated();
//        http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/api/message").permitAll();
//        http.authorizeRequests().mvcMatchers(HttpMethod.POST, "/api/message").authenticated();
//    }
//}
