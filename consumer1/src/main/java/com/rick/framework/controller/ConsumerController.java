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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}
