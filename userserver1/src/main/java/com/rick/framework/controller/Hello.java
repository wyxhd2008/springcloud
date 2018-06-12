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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}
