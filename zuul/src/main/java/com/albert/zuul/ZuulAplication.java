package com.albert.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启Zuul网关服务
@EnableDiscoveryClient
public class ZuulAplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulAplication.class);
    }
}
