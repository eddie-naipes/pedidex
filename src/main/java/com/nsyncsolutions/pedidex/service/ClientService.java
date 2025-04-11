package com.nsyncsolutions.pedidex.service;

import com.nsyncsolutions.pedidex.dto.ClientDTO;
import com.nsyncsolutions.pedidex.mapper.ClientMapper;
import com.nsyncsolutions.pedidex.model.Client;
import com.nsyncsolutions.pedidex.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientDTO create(ClientDTO clientDto) {
        Client client = clientMapper.clientDTOToClient(clientDto);
        if (client.getPhone() != null) {
            client.getPhone().forEach(phone -> phone.setId(null));
        }
        if (client.getAddresses() != null) {
            client.getAddresses().forEach(address -> address.setId(null));
        }

        Client savedClient = clientRepository.save(client);
        return clientMapper.clientToClientDTO(savedClient);
    }

    @Transactional
    public ClientDTO update(ClientDTO clientDto, UUID id) {
        return clientRepository.findById(id)
                .map(existingClient -> {
                    Client client = clientMapper.clientDTOToClient(clientDto);
                    client.setId(id);
                    Client savedClient = clientRepository.save(client);
                    return clientMapper.clientToClientDTO(savedClient);
                })
                .orElse(null);
    }

    @Transactional
    public void delete(UUID id) {
        clientRepository.findById(id).ifPresent(clientRepository::delete);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(UUID id) {
        return clientRepository.findById(id)
                .map(clientMapper::clientToClientDTO)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::clientToClientDTO)
                .toList();
    }
}