/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloWorldCommand
 * Author:   ywang7
 * Date:     2018/6/14 10:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.hystrix;

import com.netflix.hystrix.*;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/14
 * @since 1.0.0
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private final String name;

    public HelloWorldCommand(String name){
       // //最少配置:指定命令组名(CommandGroup)
       // super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
//        CommandKey，依赖命名，每个CommandKey代表一个依赖抽象，相同的依赖要使用相同的CommandKey名称。依赖隔离的根本就是对相同CommandKey的依赖做隔离。
//        CommandGroup，依赖分组，命令分组用于对依赖操作分组,便于统计,汇总等。CommandGroup是每个命令最少配置的必选参数，在不指定ThreadPoolKey的情况下，字面值用于对不同依赖的线程池/信号区分。
//        ThreadPoolKey，线程池/信号，当对同一业务依赖做隔离时使用CommandGroup做区分，但是对同一依赖的不同远程调用，例如一个是redis，一个是http，可以使用HystrixThreadPoolKey做隔离区分。即最然在业务上都是相同的组，但是需要在资源上做隔离时，是可以使用HystrixThreadPoolKey区分。
       super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
               .andCommandKey(HystrixCommandKey.Factory.asKey("query"))
               .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
               .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20))//服务线程池数量
               .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                       .withCircuitBreakerErrorThresholdPercentage(60) //熔断器关闭到打开阈值
                       .withCircuitBreakerSleepWindowInMilliseconds(3000)//熔断器打开到关闭的时间窗长度
               ));
       this.name = name;
   }

    @Override
    protected String run() throws Exception {
        // 依赖逻辑封装在run()方法中
        return "Hello " + name + ", thread: " + Thread.currentThread().getName();
    }

}
