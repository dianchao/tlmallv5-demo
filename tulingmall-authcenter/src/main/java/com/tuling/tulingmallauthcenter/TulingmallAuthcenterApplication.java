package com.tuling.tulingmallauthcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TulingmallAuthcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TulingmallAuthcenterApplication.class, args);
    }

}
