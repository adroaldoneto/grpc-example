package br.com.grpc.example.service;

import br.com.grpc.example.constant.ConstantErrorCode;
import br.com.grpc.example.exception.NotFoundException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class ServerServiceImpl extends ClientServerServiceGrpc.ClientServerServiceImplBase {

    public static final String ID_NOT_FOUND = "123";
    public static final String SERVER_MESSAGE = " => Server test successfully";

    @Override
    public void client(
            ClientRequest request, StreamObserver<ServerResponse> responseObserver) {

        if (ID_NOT_FOUND.equals(request.getInformation())) {
            throw new NotFoundException(ConstantErrorCode.ID_NOT_FOUND);
        }

        ServerResponse response = ServerResponse.newBuilder()
                .setInformation(request.getInformation() + SERVER_MESSAGE)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
