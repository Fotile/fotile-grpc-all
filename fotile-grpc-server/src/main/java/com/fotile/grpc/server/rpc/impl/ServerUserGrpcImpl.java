package com.fotile.grpc.server.rpc.impl;

import com.fotile.grpc.server.inner.client.HelloUserRequest;
import com.fotile.grpc.server.inner.client.HelloUserResponse;
import com.fotile.grpc.server.inner.client.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ServerUserGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void sayUser(HelloUserRequest request, StreamObserver<HelloUserResponse> responseObserver) {

        // ignore codes
       // super.sayUser(request, responseObserver);
        responseObserver.onCompleted();
    }

    @Override
    public void sayUserStream(HelloUserRequest request, StreamObserver<HelloUserResponse> responseObserver) {

        // ignore codes
       //  super.sayUserStream(request, responseObserver);
        responseObserver.onCompleted();
    }
}
