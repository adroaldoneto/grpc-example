package br.com.grpc.example.controller;

import br.com.grpc.example.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{clientId}")
    public String getServerResponse(@PathVariable("clientId") String clientId) {
        return clientService.getServerResponse(clientId);
    }
}
