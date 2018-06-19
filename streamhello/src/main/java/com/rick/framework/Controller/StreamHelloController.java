/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: StreamHelloController
 * Author:   ywang7
 * Date:     2018/6/19 12:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.Controller;

//import com.rick.framework.SinkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
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
public class StreamHelloController {

//    @Autowired
//    private SinkSender sinkSender;

//    @Autowired // 通过直接注入的方式注入通道，input Sink.INPUT
//    @Qualifier(SendToBinderReverse.OUTPUT)
//    private MessageChannel input;

//    @Autowired
//    private SendToBinderReverse sendToBinderReverse;
//    private SendToSender senderToSender;
    @Autowired
//    private Processor processor;
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
//        input.send(MessageBuilder.withPayload("hello, message from sinkSender").build());
//        sinkSender.output().send(MessageBuilder.withPayload("hello, message from sinkSender").build());
//        sinkSender.output2().send(MessageBuilder.withPayload("hello, message from sinkSender").build());
//        sendToBinderReverse.input().send(MessageBuilder.withPayload("hello, message from test").build());
//        senderToSender.sendToTest();
//        processor.input().send(MessageBuilder.withPayload("hello").build());
        return "hello";
    }

}
