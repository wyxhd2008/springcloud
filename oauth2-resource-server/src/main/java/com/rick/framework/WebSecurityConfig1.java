/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WebSecurityConfig1
 * Author:   ywang7
 * Date:     2018/6/25 17:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/25
 * @since 1.0.0
 */
@Configuration
@Order(2)
public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().antMatchers("/oauth/token").permitAll();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
