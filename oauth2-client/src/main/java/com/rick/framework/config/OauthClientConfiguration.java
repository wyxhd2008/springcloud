///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: OauthClientConfiguration
// * Author:   ywang7
// * Date:     2018/6/25 14:07
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.rick.framework.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestOperations;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
//import org.springframework.security.oauth2.client.token.AccessTokenRequest;
//import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
//import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
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
//public  class OauthClientConfiguration {
//    @Bean
//    protected OAuth2ProtectedResourceDetails resource() {
//
//        //we use client credential, as this use case does not need to act on behalf the user
//        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
//
//        //FIXME remove hardcoded data :)
//        resource.setAccessTokenUri("http://localhost:3333/oauth/token");
//        resource.setClientId("client_2");
//        resource.setClientSecret("123456");
//
//        return resource;
//    }
//
//    @Bean
//    public OAuth2RestOperations restTemplate() {
//        AccessTokenRequest atr = new DefaultAccessTokenRequest();
//        return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
//    }
//}
