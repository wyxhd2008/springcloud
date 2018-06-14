/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HystrixTest
 * Author:   ywang7
 * Date:     2018/6/14 10:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.hystrix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/14
 * @since 1.0.0
 */
public class HystrixTest {

    public static void main(String[] args) throws Exception{
        test1();
    }

    private static void test1() throws InterruptedException, ExecutionException, TimeoutException {
//每个Command对象只能调用一次,不可以重复调用
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");

        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();
        System.out.println("result = " + result);

        helloWorldCommand = new HelloWorldCommand("Asynchronous-hystrix");
        //异步调用,可自由控制获取结果时机,
        Future<String> future = helloWorldCommand.queue();
        //get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result = " + result);
        System.out.println("mainThread = " + Thread.currentThread().getName());
    }
}
