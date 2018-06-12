/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Hello
 * Author:   ywang7
 * Date:     2018/6/11 17:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.controller;

import com.rick.framework.model.SysUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
        * @create 2018/6/11
        * @since 1.0.0
        */
@RestController
public class Hello {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @RequestMapping("/")
    public String home() {
        return "Hello World, this is server:" + instanceId;
    }

    @RequestMapping(value="helloByName/{name}",method = RequestMethod.GET)
    public String helloByName(@PathVariable String name){
        return "hello," + name + ", this is server:" + instanceId;
    }
    @RequestMapping(value="helloByName1/{name}",method = RequestMethod.GET)
    public SysUser helloByName1(@PathVariable String name){
        SysUser sysUser=new SysUser();
        sysUser.setId(1L);
        sysUser.setUserName(name);
        sysUser.setUserEmail(name + "@qq.com");
        sysUser.setCreateTime(new Date());
        sysUser.setUserPassword(name);
        return  sysUser;
    }
}
