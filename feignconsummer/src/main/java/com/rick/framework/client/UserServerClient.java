package com.rick.framework.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="spring-cloud-server1")
public interface UserServerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home();

    @RequestMapping(method = RequestMethod.GET, value = "/helloByName/{name}")
    String helloByName(@PathVariable("name") String name);
}
