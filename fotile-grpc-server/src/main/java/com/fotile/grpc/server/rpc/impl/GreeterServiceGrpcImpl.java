package com.fotile.grpc.server.rpc.impl;

import com.fotile.grpc.client.GreeterServiceGrpc;
import com.fotile.grpc.client.HelloRequest;
import com.fotile.grpc.client.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterServiceGrpcImpl extends GreeterServiceGrpc.GreeterServiceImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

    // build response
    String message = "Hello, " + request.getName() + "!";
    HelloResponse response = HelloResponse.newBuilder().setMessage(message).build();

    // send response
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void sayHelloStream(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    // send more response
    for (int i = 1; i <= 5; i++) {
      String message = "Hello " + request.getName() + "! This is message " + i;
      HelloResponse response = HelloResponse.newBuilder().setMessage(message).build();
      responseObserver.onNext(response);

      // mock delay
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }
    }

    // completed it
    responseObserver.onCompleted();
  }
}
