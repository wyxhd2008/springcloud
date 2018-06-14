/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserCommand
 * Author:   ywang7
 * Date:     2018/6/14 13:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.rick.framework.model.SysUser;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/14
 * @since 1.0.0
 */
public class UserCommand extends HystrixCommand {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate,Long id){
        super(setter);
        this.restTemplate=restTemplate;
        this.id=id;
    }

    @Override
    protected Object run() throws Exception {
        return restTemplate.getForEntity("http://SPRING-CLOUD-SERVER1/helloById/id={1}",SysUser.class,id).getBody();
    }
}
