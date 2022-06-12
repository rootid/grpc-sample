package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
            = HelloServiceGrpc.newBlockingStub(channel);

        HelloServiceOuterClass.HelloResponse helloResponse = stub.sayHello(HelloServiceOuterClass.HelloRequest.newBuilder()
            .setFirstName("John")
            .setLastName("Smith")
            .build());

        System.out.println("Response from the server = " + helloResponse.getGreeting());
        channel.shutdown();
    }
}
