package com.rick.framework.controller;

import com.rick.framework.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQHelloController {

    @Autowired
    private Sender sender;

    @RequestMapping(value="hello",method = RequestMethod.GET)
    public String helloByName(){
        sender.send();
        return "hello";
    }

}
