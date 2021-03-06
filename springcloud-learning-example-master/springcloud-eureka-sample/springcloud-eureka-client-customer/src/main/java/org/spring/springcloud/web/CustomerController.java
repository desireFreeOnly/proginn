package org.spring.springcloud.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Customer HelloWorld 案例
 * <p>
 * Created by bysocket on 06/22/17.
 */
@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private RestTemplate restTemplate; // HTTP 访问操作类
    
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/customer")
    public String customer() {
        String providerMsg = restTemplate.getForEntity("http://PROVIDER-SERVICE/provider",
                String.class).getBody();

        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
    }
    
    @GetMapping("/hello")
    public String hello(String name) {
        return "hi," + name + ",this is springcloud-euraka-client-customer ";
    }
    
    @GetMapping("/hello_ribbon") 
    public String hello_ribbon(String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-service");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello?name=" + name;
        System.out.println("url地址为："+url);
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("name",name);
        return restTemplate.getForObject("http://provider-service/hello?name={name}", String.class,uriVariables);
    } 
}