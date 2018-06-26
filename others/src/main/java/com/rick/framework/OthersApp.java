/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OthersApp
 * Author:   ywang7
 * Date:     2018/6/26 13:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import com.rick.framework.config.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/26
 * @since 1.0.0
 */
@SpringBootApplication
@Import(MyConfiguration.class)
@ImportResource("/simple-context.xml")
@RestController
public class OthersApp {

    public static void main(String[] args) {
        SpringApplication.run(OthersApp.class, args);
    }

    @Autowired
    @Resource(name="cats")
    public List<String> myCatsList;

    @Autowired
    @Resource(name="dogs")
    public List<String> myDogsList;

    @Autowired
    @Resource(name="cows")
    public List<String> myCowsList;

    @RequestMapping("/")
    public String hello() {
        return "Hello from Spring Boot! cats are " +
                String.join(": ", myCatsList)+" and dogs are " +
                String.join(": ", myDogsList) + " and cows are " +
                String.join(": ", myCowsList);
    }

}
