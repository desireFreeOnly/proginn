package org.springcloud.eureka.client.provider.second.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
	@GetMapping("/hello")
	public String hello(String name) {
		System.out.println("springcloud-eureka-client-provider服务被调用，参数name值为:" + name);
		return name + ",this is springcloud-eureka-client-provider";
	}
}
