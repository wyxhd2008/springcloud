/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: StreamConsumerApplicatiion
 * Author:   ywang7
 * Date:     2018/6/19 14:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/19
 * @since 1.0.0
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class StreamConsumerApplicatiion implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplicatiion.class, args);
    }

    @Autowired
    @Qualifier("output")
    MessageChannel output;
    @Override
    public void run(String... args) throws Exception {
        // 字符串类型发送MQ
        System.out.println("字符串信息发送");
        output.send(MessageBuilder.withPayload("大家好").build());
    }
}
