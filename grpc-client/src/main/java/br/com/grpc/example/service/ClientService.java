package br.com.grpc.example.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @GrpcClient("cloud-grpc-server-consul")
    private ClientServerServiceGrpc.ClientServerServiceBlockingStub stub;

    public String getServerResponse(String clientId) {
        ServerResponse response = stub.client(ClientRequest.newBuilder()
                .setInformation(clientId)
                .build());
        return response.getInformation();
    }
}