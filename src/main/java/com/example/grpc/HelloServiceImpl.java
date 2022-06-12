package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloServiceOuterClass.HelloRequest request, StreamObserver<HelloServiceOuterClass.HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
            .append("Hello, ")
            .append(request.getFirstName())
            .append(" ")
            .append(request.getLastName())
            .toString();

        HelloServiceOuterClass.HelloResponse response = HelloServiceOuterClass.HelloResponse.newBuilder()
            .setGreeting(greeting)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
