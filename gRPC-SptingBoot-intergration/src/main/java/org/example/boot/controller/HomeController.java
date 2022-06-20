package org.example.boot.controller;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.helloworld.GreeterGrpc;
import org.example.grpc.helloworld.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * grpc测试
 * @Author Administrator
 * @Date 2022/6/12 17:33
 */
@RestController
public class HomeController {

    @GrpcClient("greeterService")
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    @GetMapping("/hello")
    public String helloTest(@RequestParam(name = "name") String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        return greeterBlockingStub.sayHello(request).getMessage();
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
