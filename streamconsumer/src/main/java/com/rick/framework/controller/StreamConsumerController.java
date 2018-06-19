/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: StreamConsumerController
 * Author:   ywang7
 * Date:     2018/6/19 14:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.controller;

import com.rick.framework.SendToReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/19
 * @since 1.0.0
 */
@RestController
public class StreamConsumerController {
//    @Autowired
//    private SendToReceiver sendToReceiver;

//    @RequestMapping(value="/hello",method = RequestMethod.GET)
//    public String hello(){
////        input.send(MessageBuilder.withPayload("hello, message from sinkSender").build());
////        sinkSender.output().send(MessageBuilder.withPayload("hello, message from sinkSender").build());
////        sinkSender.output2().send(MessageBuilder.withPayload("hello, message from sinkSender").build());
//        sendToReceiver.sendToTest();
//        return "hello";
//    }
}
