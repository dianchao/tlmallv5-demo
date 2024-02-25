package com.tuling;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableRedisHttpSession //开启springsession
@EnableFeignClients
public class TulingmallMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(TulingmallMemberApplication.class, args);
	}

}
