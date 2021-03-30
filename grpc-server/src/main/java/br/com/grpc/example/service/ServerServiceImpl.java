package br.com.grpc.example.service;

import br.com.grpc.example.constant.ConstantErrorCode;
import br.com.grpc.example.exception.NotFoundException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class ServerServiceImpl extends ClientServerServiceGrpc.ClientServerServiceImplBase {

    @Override
    public void client(
            ClientRequest request, StreamObserver<ServerResponse> responseObserver) {

        if ("123".equals(request.getInformation())) {
            throw new NotFoundException(ConstantErrorCode.ID_NOT_FOUND);
        }

        ServerResponse response = ServerResponse.newBuilder()
                .setInformation(request.getInformation() + " => " + "Server test successfully")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
