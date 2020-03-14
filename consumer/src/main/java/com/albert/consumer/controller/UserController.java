package com.albert.consumer.controller;

import com.albert.consumer.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息
    
    @GetMapping("/{id}")
    public User userService(@PathVariable("id") Long id) {
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息
//        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";
        String baseUrl = "http://user-service/user/" + id;
        User user = restTemplate.getForObject(baseUrl, User.class);
    
//        for (int i = 0; i < 100; i++) {
//            ServiceInstance instanceX = this.client.choose("user-service");
//            System.out.println(instanceX.getHost() + ":" + instanceX.getPort());
//        }
        return user;
    }
}
