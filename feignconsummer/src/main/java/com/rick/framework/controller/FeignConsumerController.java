package com.rick.framework.controller;

import com.rick.framework.client.UserServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {

    @Autowired
    UserServerClient userServerClient;

    @RequestMapping("/")
    public String home() {
        return userServerClient.home();
    }

    @RequestMapping(value="helloByName/{name}",method = RequestMethod.GET)
    public String helloByName(@PathVariable String name){
        return userServerClient.helloByName(name);
    }

}
