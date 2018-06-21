package com.rick.framework.Controller;

import com.netflix.discovery.converters.Auto;
import com.rick.framework.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    private HelloService helloService;
    @RequestMapping(value="helloByName/{name}",method = RequestMethod.GET)
    public String helloByName(@PathVariable String name){
        return helloService.hiService(name);
    }

}
