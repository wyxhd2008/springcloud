/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ConfigClient3Application
 * Author:   ywang7
 * Date:     2018/6/21 16:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/21
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient3Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3Application.class, args);
    }

}
