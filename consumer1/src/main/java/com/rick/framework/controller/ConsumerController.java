/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ConsumerController
 * Author:   ywang7
 * Date:     2018/6/12 16:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.controller;

import com.rick.framework.model.SysUser;
import com.rick.framework.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/12
 * @since 1.0.0
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value="/helloService", method=RequestMethod.GET)
    public String helloServie(){
        return consumerService.helloService();
    }

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String helloConsume(){
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/",String.class).getBody();
    }

    @RequestMapping(value="/hello/{name}", method=RequestMethod.GET)
    public String helloConsumeByName(@PathVariable String name){
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/helloByName/name={1}",String.class,name).getBody();
    }

    @RequestMapping(value="/hello1/{name}", method=RequestMethod.GET)
    public String helloConsumeByName1(@PathVariable String name){
        UriComponents uriComponents=UriComponentsBuilder.fromUriString("http://SPRING-CLOUD-SERVER1/helloByName/name={name}")
                .build()
                .expand(name)
                .encode();
        URI uri=uriComponents.toUri();
        return restTemplate.getForEntity(uri,String.class).getBody();
    }

    @RequestMapping(value="/hello2/{name}", method=RequestMethod.GET)
    public SysUser helloConsumeByName2(@PathVariable String name){
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/helloByName1/name={1}",SysUser.class,name).getBody();
    }

    @RequestMapping(value="/getByUserId/{id}", method=RequestMethod.GET)
    public void getByUserId(@PathVariable Long id){
        consumerService.getByUserIdAsync(id);
    }

    @RequestMapping(value="/hello1", method=RequestMethod.GET)
    public String helloConsume1(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("SPRING-CLOUD-SERVER1");
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/",String.class).getBody();
    }

    @RequestMapping(value="/findUser/{id}", method=RequestMethod.GET)
    public SysUser findUser(@PathVariable Long id){
        return consumerService.find(id);
    }


}
