/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: AuthorizationServerConfig1
 * Author:   ywang7
 * Date:     2018/6/25 16:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/25
 * @since 1.0.0
 */
@Configuration
public class AuthorizationServerConfig1 extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    /**
     * 四种授权码模式：
     * password
     * client_credentials
     * authorization_code
     * implicit
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("webapp")
                .secret("websecret")
                .authorizedGrantTypes("password")
                .scopes("read,write,trust")
        .and()
                .withClient("client_1")
                .secret("123456")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
         .and()
                .withClient("client_3")
                .secret("123456")
                .redirectUris("http://localhost:2223/login")
                .authorizedGrantTypes("authorization_code")
                .scopes("select")
        .and()
                .withClient("webapp")
                .scopes("select")
                .authorizedGrantTypes("implicit");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception{
        security.checkTokenAccess("permitAll()");
    }

}
