package org.example.boot.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.grpc.helloworld.GreeterGrpc;
import org.example.grpc.helloworld.HelloReply;
import org.example.grpc.helloworld.HelloRequest;

/**
 * @Author Administrator
 * @Date 2022/6/12 17:36
 */
@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("hello "+ request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
