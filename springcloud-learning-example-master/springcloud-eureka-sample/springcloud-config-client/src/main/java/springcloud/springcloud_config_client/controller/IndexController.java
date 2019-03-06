package springcloud.springcloud_config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@Value("${name}")
	private String name;

	@RequestMapping("/name")
	private String name() {
		System.out.println("*****************:"+name);
		return name;
	}

}
