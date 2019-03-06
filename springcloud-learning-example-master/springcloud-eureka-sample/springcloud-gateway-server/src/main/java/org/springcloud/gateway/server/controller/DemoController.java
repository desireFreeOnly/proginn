package org.springcloud.gateway.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@GetMapping("/hello")
    public String hello(String name) {
        return "hi," + name + ",this is zuul api! ";
    }
}
