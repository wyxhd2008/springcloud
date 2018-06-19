/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SinkReceiver
 * Author:   ywang7
 * Date:     2018/6/19 10:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/19
 * @since 1.0.0
 */
//用来指定一个或多个定义了@Input 或者 @Output注解的接口，实现对消息通道的绑定。
//@EnableBinding({Sink.class,SinkSender.class})
//public class SinkReceiver {
//
//    @StreamListener(Sink.INPUT)//将被修饰的方法注册为消息中间件上数据流的事件监听器，
//    public void receive(Object payload){
//        System.out.println("Received:"  +  payload);
//    }
//
//}
