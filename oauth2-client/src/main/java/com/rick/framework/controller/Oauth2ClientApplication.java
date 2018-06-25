///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: Oauth2ClientApplication
// * Author:   ywang7
// * Date:     2018/6/25 14:08
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.rick.framework.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.OAuth2RestOperations;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author ywang7
// * @create 2018/6/25
// * @since 1.0.0
// */
//@RestController
//public class Oauth2ClientApplication {
//
//    @Autowired
//    private OAuth2RestOperations restTemplate;
//
//    @RequestMapping(value = "/api/message", method = RequestMethod.GET)
//    public Map<String, String> getMessage() {
//        System.out.println("+++++++++++++++++++++test");
//        return restTemplate.getForObject("http://localhost:2225", Map.class);
//    }
//
//    @RequestMapping(value = "/api/message", method = RequestMethod.POST)
//    public void saveMessage(@RequestBody String newMessage) {
//        //FIXME, this method will require consent screen and the user will have the scope for writing the message
//    }
//}
