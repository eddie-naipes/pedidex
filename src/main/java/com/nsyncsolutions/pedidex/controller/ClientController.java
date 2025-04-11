package com.nsyncsolutions.pedidex.controller;

import com.nsyncsolutions.pedidex.dto.ClientDTO;
import com.nsyncsolutions.pedidex.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.nsyncsolutions.pedidex.utils.ApiConstants.API_VERSION;
import static com.nsyncsolutions.pedidex.utils.ApiConstants.CLIENT;

@RestController
@RequestMapping(API_VERSION + CLIENT)
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody @Valid ClientDTO clientDto) {
        ClientDTO clientDTO = clientService.create(clientDto);
        if (clientDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable UUID id) {
        ClientDTO clientDTO = clientService.findById(id);
        if (clientDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> clientDTOs = clientService.findAll();
        if (clientDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@RequestBody @Valid ClientDTO clientDto, @PathVariable UUID id) {
        ClientDTO clientDTO = clientService.update(clientDto, id);
        if (clientDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}