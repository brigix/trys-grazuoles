package lt.sdacademy.booking.beauty.services;

import java.util.List;
import lt.sdacademy.booking.beauty.models.entities.ClientEntity;
import lt.sdacademy.booking.beauty.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity create(ClientEntity client) {
        return clientRepository.save(client);
    }

    public List<ClientEntity> getClient() {
        return clientRepository.findAll();
    }


}

