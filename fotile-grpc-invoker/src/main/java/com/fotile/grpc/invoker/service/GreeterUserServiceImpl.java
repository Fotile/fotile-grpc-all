package com.fotile.grpc.invoker.service;

import com.fotile.grpc.client.GreeterServiceGrpc;
import com.fotile.grpc.client.HelloRequest;
import com.fotile.grpc.client.HelloResponse;
import com.google.common.util.concurrent.ListenableFuture;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class GreeterUserServiceImpl {

  private final GreeterServiceGrpc.GreeterServiceBlockingStub greeterServiceBlockingClient;
  private final GreeterServiceGrpc.GreeterServiceFutureStub greeterServiceFutureClient;

  public GreeterUserServiceImpl(
          @GrpcClient("grpc-server") GreeterServiceGrpc.GreeterServiceBlockingStub greeterServiceBlockingClient,
          @GrpcClient("grpc-server") GreeterServiceGrpc.GreeterServiceFutureStub greeterServiceFutureStub) {
    this.greeterServiceBlockingClient = greeterServiceBlockingClient;
      this.greeterServiceFutureClient = greeterServiceFutureStub;
  }

  public String sayBlockHello(Long id) {
      com.fotile.grpc.client.HelloRequest request =
              com.fotile.grpc.client.HelloRequest.newBuilder()
                      .setName("hhahah")
                      .build();
      HelloResponse helloResponse = greeterServiceBlockingClient.sayHello(request);
      return helloResponse.getMessage();
  }

    public String sayFutureHello(Long id) {
        com.fotile.grpc.client.HelloRequest request =
                com.fotile.grpc.client.HelloRequest.newBuilder()
                        .setName("hhahah")
                        .build();
        ListenableFuture<HelloResponse> future = greeterServiceFutureClient.sayHello(request);
        try {
            HelloResponse helloResponse = future.get(500, TimeUnit.MILLISECONDS);
            return helloResponse.getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }


}
