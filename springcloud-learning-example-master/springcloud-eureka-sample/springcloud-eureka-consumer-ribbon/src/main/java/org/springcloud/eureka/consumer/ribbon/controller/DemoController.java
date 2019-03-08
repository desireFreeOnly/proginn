package org.springcloud.eureka.consumer.ribbon.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
/**
 * ribbon访问客户端示例
 * @author dfwl
 */
@RestController
@Slf4j
public class DemoController {
	@Autowired 
    RestTemplate restTemplate;
	@GetMapping("/hello") 
    public String hello(String name) {
        //直接使用服务名进行访问
        log.info("请求参数name:{}", name);
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("name",name);
        return restTemplate.getForObject("http://provider-service/hello?name={name}", String.class,uriVariables);
    } 
}
