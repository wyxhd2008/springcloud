/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SendToSender
 * Author:   ywang7
 * Date:     2018/6/19 14:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.cloud.stream.messaging.Processor;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/19
 * @since 1.0.0
 */
@EnableBinding(value = {Processor.class})
public class SendToSender {

    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "3000", maxMessagesPerPoll = "1"))
    public MessageSource<String> sendToTest() {
        System.out.println("test!!!!!!");
        return () -> new GenericMessage<>("hello");
    }

    @StreamListener(Processor.INPUT) // 监听input通道
    public void receiveFromInput(String message) {
        System.out.println("send to binder:" + message);
    }

}
