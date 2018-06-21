/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ActuatorController
 * Author:   ywang7
 * Date:     2018/6/21 12:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.Controller;

import com.rick.framework.Service.ActuatorService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ActuatorController {

    @Autowired
    private ActuatorService actuatorService;

    @RequestMapping(value="/helloService", method=RequestMethod.GET)
    public String helloServie(){
        return actuatorService.helloService();
    }

    @RequestMapping(value="/helloService1", method=RequestMethod.GET)
    public String helloServie1(){
        return actuatorService.helloService();
    }


}
