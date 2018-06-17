package com.rick.framework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PropertiesController {

    @Value("${foo}")
    private String foo;

    @RequestMapping(value="/foo",method = RequestMethod.GET)
    public String helloFoo() {
        return this.foo;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World, this is server:";
    }

}
