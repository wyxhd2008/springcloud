/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ConfigClientConfig
 * Author:   ywang7
 * Date:     2018/6/21 17:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/21
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "")
public class ConfigClientConfig {

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    private String foo;

    @Override
    public String toString() {
        return "ConfigClientConfig{" +
                "foo='" + foo + '\'' +
                '}';
    }
}
