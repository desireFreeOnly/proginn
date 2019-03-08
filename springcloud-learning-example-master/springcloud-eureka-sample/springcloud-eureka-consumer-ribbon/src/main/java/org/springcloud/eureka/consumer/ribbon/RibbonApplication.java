package org.springcloud.eureka.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@EnableFeignClients    // feign 标识
@EnableDiscoveryClient // Eureka Discovery Client 标识
@SpringBootApplication // Spring Boot 应用标识
@Slf4j
public class RibbonApplication {
	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(RibbonApplication.class, args);
		log.info("spring-cloud-eureka-consumer-ribbon启动!");
	}

	// 添加 @LoadBalanced 使其具备了使用LoadBalancerClient 进行负载均衡的能力
	@Bean
	@LoadBalanced
	public RestTemplate restTemplage() {
		return new RestTemplate();
	}
}
