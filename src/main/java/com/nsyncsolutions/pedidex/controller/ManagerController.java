package com.nsyncsolutions.pedidex.controller;

import com.nsyncsolutions.pedidex.dto.ManagerDTO;
import com.nsyncsolutions.pedidex.service.ManagerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/managers")
@AllArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerDTO> create(@RequestBody @Valid ManagerDTO managerDTO) {
        ManagerDTO managerCreated = managerService.create(managerDTO);
        return ResponseEntity.ok(managerCreated);
    }

    @GetMapping
    public ResponseEntity<List<ManagerDTO>> findAll() {
        List<ManagerDTO> managerDTOs = managerService.findAll();
        if (managerDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(managerDTOs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> findById(@PathVariable UUID id) {
        ManagerDTO managerDTO = managerService.findById(id);
        if (managerDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(managerDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ManagerDTO> update(@RequestBody @Valid ManagerDTO managerDTO) {
        ManagerDTO updatedManager = managerService.update(managerDTO);
        if (updatedManager == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ManagerDTO> delete(@PathVariable UUID id) {
        managerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
