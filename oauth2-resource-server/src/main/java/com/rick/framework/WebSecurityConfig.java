///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: WebSecurityConfig
// * Author:   ywang7
// * Date:     2018/6/25 16:46
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.rick.framework;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user1").password("password1").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//    }
//
//}
