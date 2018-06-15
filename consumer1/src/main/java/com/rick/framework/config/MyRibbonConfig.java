/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MyRibbonConfig
 * Author:   ywang7
 * Date:     2018/6/13 10:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/13
 * @since 1.0.0
 */
@Configuration
@ExcudeAnnotation
public class MyRibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
