package com.rick.framework; /**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: com.rick.framework.oauth2ClientApplication
 * Author:   ywang7
 * Date:     2018/6/25 14:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/25
 * @since 1.0.0
 */
@SpringBootApplication
@EnableOAuth2Client
@RestController
public class oauth2ClientApplication {

    @Autowired
    public OAuth2RestTemplate restTemplate;

    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext());
    }

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        details.setAccessTokenUri("http://localhost:3333/oauth/token");
        details.setClientId("webapp");
        details.setClientSecret("websecret");
        details.setGrantType("password");
        return details;
    }

//    @Bean
//    public AccessTokenRequest accessTokenRequest(){
////        AccessTokenRequest defaultAccessTokenRequest = new DefaultAccessTokenRequest();
//        AccessTokenRequest defaultAccessTokenRequest = this.restTemplate.getOAuth2ClientContext().getAccessTokenRequest();
//        User user = (User) ((Authentication)principal).getPrincipal();
//
//        accessTokenRequest.set("username", user.getUsername());
//        accessTokenRequest.set("password", user.getPassword());
//
//        //        Map<String, List<String>> headers = new HashMap<String, List<String>>();
////        List<String> headerList=new ArrayList<String>();
////        headerList.add("Basic " + oauthInfo.get("public_key"));
////        headers.put("Authorization", headerList);
////        defaultAccessTokenRequest.setHeaders(headers);
////        defaultAccessTokenRequest.setCurrentUri(oauthInfo.get("redirect_uri"));
//        return defaultAccessTokenRequest;
//    }

    @RequestMapping("/execute")
    public String execute(Principal principal) throws URISyntaxException {
        User user = (User) ((Authentication)principal).getPrincipal();
        URI uri = new URI("http://localhost:2225/resource/endpoint");
        RequestEntity<String> request = new RequestEntity<String>(HttpMethod.POST, uri);
        AccessTokenRequest accessTokenRequest = this.restTemplate.getOAuth2ClientContext().getAccessTokenRequest();
        accessTokenRequest.set("username", user.getUsername());
        accessTokenRequest.set("password", user.getPassword());
        System.out.println(" token is:" + restTemplate.getAccessToken().getValue());
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setOutputStreaming(false);
//        restTemplate.setRequestFactory(requestFactory);
        return restTemplate.exchange(request, String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(oauth2ClientApplication.class, args);
    }
}
