package br.com.grpc.example.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public static final String SERVER = "localhost";
    public static final int PORT = 9090;

    public String getServerResponse() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(SERVER, PORT)
                .usePlaintext()
                .build();
        ClientServerServiceGrpc.ClientServerServiceBlockingStub stub = ClientServerServiceGrpc.newBlockingStub(managedChannel);
        ServerResponse response = stub.client(ClientRequest.newBuilder()
                .setInformation("Client test successfully")
                .build());
        managedChannel.shutdown();
        return response.getInformation();
    }
}