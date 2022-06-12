package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {
    public static void main( String[] args ) throws IOException, InterruptedException {
        System.out.println( "Hello World!" );

        Server server = ServerBuilder
            .forPort(8080)
            .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
