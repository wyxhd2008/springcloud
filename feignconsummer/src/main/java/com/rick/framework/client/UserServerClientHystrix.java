package com.rick.framework.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class UserServerClientHystrix implements UserServerClient {
    @Override
    public String home() {
        return null;
    }

    @Override
    public String helloByName(@RequestParam(value = "name") String name) {
        return "hello" +name+", this messge send failed ";
    }
}
