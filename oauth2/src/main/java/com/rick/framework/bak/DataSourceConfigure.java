//package com.rick.framework.com.rick.framework.config;
//
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.cloud.context.com.rick.framework.config.annotation.RefreshScope;
//import org.springframework.context.annotation.Bean;
//
//import javax.sql.DataSource;
//
////@RefreshScope
////@Configuration
//public class DataSourceConfigure {
//
//    @Bean
//    @RefreshScope// 刷新配置文件
//    @ConfigurationProperties(prefix="spring.datasource") // 数据源的自动配置的前缀
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//}
