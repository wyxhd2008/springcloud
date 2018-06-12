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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
