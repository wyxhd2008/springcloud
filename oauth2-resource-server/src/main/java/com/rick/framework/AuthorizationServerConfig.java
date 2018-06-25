///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: AuthorizationServerConfig
// * Author:   ywang7
// * Date:     2018/6/25 16:45
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.rick.framework;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
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
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory().withClient("webapp").secret("websecret").authorizedGrantTypes("password").scopes("read,write,trust");
//    }
//}