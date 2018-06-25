package com.rick.framework;

//import com.rick.framework.com.rick.framework.config.ExcudeAnnotation;
//import com.rick.framework.com.rick.framework.config.MyRibbonConfig;
//import com.rick.framework.com.rick.framework.config.ExcudeAnnotation;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.rick.framework.config.ExcudeAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.HystrixMetricsProperties;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableSwagger2
//@EnableHystrixDashboard
//@EnableTurbine
// 使用此规则不可放在 可扫描的路径下, 如果非要放置, 需要加自定义注解
//@RibbonClient(name = "SPRING-CLOUD-SERVER1", configuration = MyRibbonConfig.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {ExcudeAnnotation.class})})
//@ComponentScan(basePackages = {"com.rick.framework","org.springframework.cloud.client.loadbalancer"})
public class Consumer1Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }

}
