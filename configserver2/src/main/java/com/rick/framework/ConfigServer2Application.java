/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ConfigServer2Application
 * Author:   ywang7
 * Date:     2018/6/21 13:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/21
 * @since 1.0.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer2Application {

      public static void main(String[] args) {
        SpringApplication.run(ConfigServer2Application.class, args);
    }
}
