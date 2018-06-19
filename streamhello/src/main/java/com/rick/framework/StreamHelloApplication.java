/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: StreamHelloApplication
 * Author:   ywang7
 * Date:     2018/6/19 10:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/19
 * @since 1.0.0
 */
@SpringBootApplication
//@EnableBinding(value = {Processor.class})
public class StreamHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamHelloApplication.class, args);
    }

//    @Bean
//    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
//    public MessageSource<String> sendToTest() {
//        System.out.println("test!!!!!!");
//        return () -> new GenericMessage<>("hello");
//    }
}
