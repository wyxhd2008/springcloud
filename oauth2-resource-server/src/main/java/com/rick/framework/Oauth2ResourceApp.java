/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Oauth2ResourceApp
 * Author:   ywang7
 * Date:     2018/6/25 14:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
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
//@RestController
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableResourceServer
//@EnableAuthorizationServer
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Oauth2ResourceApp {

    @RequestMapping("/resource/endpoint")
    @PreAuthorize("hasRole('ADMIN')")
    public String endpoint(Principal principal){
        return "Welcome " + principal.getName()+ ", This message is protected by the resource server.";
    }

    @Bean
    public RemoteTokenServices remoteTokenServices(){
        RemoteTokenServices remoteTokenServices=new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:3333/oauth/check_token");
        remoteTokenServices.setClientId("webapp");
        remoteTokenServices.setClientSecret("websecret");
        return remoteTokenServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ResourceApp.class, args);
    }
//    private String message = "Hello world!";
//
//    @PreAuthorize("#oauth2.hasScope('resource-server-read')")
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public Map<String, Object> home() {
//        return Collections.singletonMap("message", message);
//    }
//
//    @PreAuthorize("#oauth2.hasScope('resource-server-write')")
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public void updateMessage(@RequestBody String message) {
//        this.message = message;
//    }

}
