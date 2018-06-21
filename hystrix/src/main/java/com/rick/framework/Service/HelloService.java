package com.rick.framework.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/helloByName/name={1}",String.class,name).getBody();
    }

    public String hiError(String name) {
        System.out.println("error");
        return "hi,"+name+",sorry,error!";
    }


}
