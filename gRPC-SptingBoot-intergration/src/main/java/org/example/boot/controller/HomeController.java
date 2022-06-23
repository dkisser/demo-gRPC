package org.example.boot.controller;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.helloworld.GreeterGrpc;
import org.example.grpc.helloworld.HelloRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * grpc测试
 * @Author Administrator
 * @Date 2022/6/12 17:33
 */
@RestController
public class HomeController {

    @GrpcClient("greeterService")
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    @GrpcClient("greeterService1")
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub1;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String helloTest(@RequestParam(name = "name") String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        return greeterBlockingStub.sayHello(request).getMessage();
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/listUrl")
    public String listUrl() {
        String result = "";
        List<ServiceInstance> store = discoveryClient.getInstances("demo-grpc");
        for (ServiceInstance serviceInstance : store) {
            result += serviceInstance.getUri().toString();
        }
        return result;
    }

    @GetMapping("/hello2")
    public String helloTest2(@RequestParam(name = "name") String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        return greeterBlockingStub1.sayHello(request).getMessage();
    }

}
