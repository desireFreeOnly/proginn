package org.springcloud.eureka.consumer.ribbon.controller;

import org.springcloud.eureka.consumer.ribbon.IHelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * feign示例
 * 
 * @author dfwl
 */
@RestController
@Slf4j
public class FeignDemoController {
	@Autowired
	IHelloClient helloClient;

	@GetMapping("/hello_feign")
	public String hello_feign(String name) {
		// 直接使用服务名进行访问
		log.info("使用feign调用服务，参数name:{}", name);
		return helloClient.hello(name);
	}
}
