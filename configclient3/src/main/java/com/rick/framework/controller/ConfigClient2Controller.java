/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ConfigClient2Controller
 * Author:   ywang7
 * Date:     2018/6/21 16:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.controller;

import com.rick.framework.config.ConfigClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/21
 * @since 1.0.0
 */
@RestController
//@RefreshScope
public class ConfigClient2Controller {
    @Value("${foo}")
    private String foo;

    @Autowired
    private ConfigClientConfig configClientConfig;

    @RequestMapping(value="/foo",method = RequestMethod.GET)
    public String helloFoo() {
        return foo + ";" + configClientConfig.toString();
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World, this is server:";
    }

}
