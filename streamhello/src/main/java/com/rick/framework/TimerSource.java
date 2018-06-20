package com.rick.framework;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

//@EnableBinding(Source.class)
//public class TimerSource {
//    @Bean
//    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "3000", maxMessagesPerPoll = "1"))
//    public MessageSource<String> timerMessageSource() {
//        return () -> {
//            System.out.println("hello! timer");
//            return new GenericMessage<>("test");
//        };
//    }
//}
