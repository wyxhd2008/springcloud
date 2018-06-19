/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SendToReceiver
 * Author:   ywang7
 * Date:     2018/6/19 13:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/19
 * @since 1.0.0
 */

//@EnableBinding(value = {Processor.class})
//public class SendToReceiver {
//
//    @StreamListener(Processor.INPUT) // 监听input通道
//    @SendTo(Processor.OUTPUT) // 返回处理结果到output通道
//    public Object receiveFromInput(Object payload){
//        System.out.print("test from input");
//        return "From input channel and return -" + payload;
//    }
//}
