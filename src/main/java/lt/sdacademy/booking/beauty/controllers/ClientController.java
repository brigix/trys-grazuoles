package lt.sdacademy.booking.beauty.controllers;

import java.util.List;
import lt.sdacademy.booking.beauty.models.entities.ClientEntity;
import lt.sdacademy.booking.beauty.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientEntity> getClient(@RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
        return clientService.getClient();
    }

    @PostMapping
    public ClientEntity create(@RequestBody ClientEntity client) {
        return clientService.create(client);
    }

}
