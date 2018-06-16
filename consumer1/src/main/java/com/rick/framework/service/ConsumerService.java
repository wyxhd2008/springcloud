package com.rick.framework.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.rick.framework.model.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/",String.class).getBody();
    }

    private String helloFallback(){
        return "server error";
    }

    public Future<SysUser> getByUserIdAsync(final Long id){
        return new AsyncResult<SysUser>() {
            @Override
            public SysUser invoke() {
                return restTemplate.getForObject("http://SPRING-CLOUD-SERVER1/helloById/id={1}",SysUser.class,id);
            }
        };
    }

    //定义缓存key
    @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")
    @HystrixCommand
    public SysUser getUserById(Long id){
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/helloById/id={1}",SysUser.class,id).getBody();
    }

    private Long getUserByIdCacheKey(Long id){
        return id;
    }

    @CacheResult
    @HystrixCommand
    public SysUser getUserById1(@CacheKey("id") Long id){
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/helloById/id={1}",SysUser.class,id).getBody();
    }

    @CacheRemove(commandKey = "getUserById")
    @HystrixCommand
    public  void update(@CacheKey("id") SysUser sysUser){
         restTemplate.postForObject("http://SPRING-CLOUD-SERVER1/updateUser",sysUser,SysUser.class);
    }

    //请求合并
    @HystrixCollapser(batchMethod = "findAll",collapserProperties = {
            @HystrixProperty(name="timerDelayInMilliseconds",value = "50"),
            @HystrixProperty(name = "maxRequestsInBatch", value = "200"),
    })
    public  SysUser find(Long id){
        return null;
    }

    @HystrixCommand
    public List<SysUser> findAll(List<Long> ids){
        return restTemplate.getForObject("http://SPRING-CLOUD-SERVER1/users?ids={1}",List.class,StringUtils.join(ids,","));
    }

}
