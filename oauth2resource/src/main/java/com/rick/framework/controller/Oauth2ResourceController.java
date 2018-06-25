//package com.rick.framework.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableResourceServer
//public class Oauth2ResourceController {
//
//    @RequestMapping(value="/hello", method= RequestMethod.GET)
//    public String hello(){
//        return "hello, welcome to oauth2 study!";
//    }
//
//    @PreAuthorize("#oauth2.hasScope('resource-server-read')")
//    @RequestMapping(value="/order/{id}", method= RequestMethod.GET)
//    public String hello1(@PathVariable String id){
//        return "hello, " + id + " welcome to oauth2 study!";
//    }
//
//    @GetMapping("/demo")
//    @PreAuthorize("hasAuthority('query-demo')")
//    public String getDemo(){
//        return "good";
//    }
//
//}
