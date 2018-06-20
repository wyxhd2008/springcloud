package com.rick.framework.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="spring-cloud-server1",fallback = UserServerClientHystrix.class)
public interface UserServerClient {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    String home();

    @RequestMapping(value="helloByName/{name}",method = RequestMethod.GET)
    String helloByName(@PathVariable("name") String name);
}
