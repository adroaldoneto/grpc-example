package br.com.grpc.example.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class ServerServiceImpl extends ClientServerServiceGrpc.ClientServerServiceImplBase {

    @Override
    public void client(
            ClientRequest request, StreamObserver<ServerResponse> responseObserver) {
        ServerResponse response = ServerResponse.newBuilder()
                .setInformation(request.getInformation() + " => " + "Server test successfully")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
