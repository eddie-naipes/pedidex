package com.nsyncsolutions.pedidex.service;

import com.nsyncsolutions.pedidex.dto.ManagerDTO;
import com.nsyncsolutions.pedidex.mapper.ManagerMapper;
import com.nsyncsolutions.pedidex.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;


    public ManagerDTO create(ManagerDTO managerDto) {
        return managerMapper.managerToManagerDTO(managerRepository.save(managerMapper.managerDTOToManager(managerDto)));
    }

    public List<ManagerDTO> findAll() {
        return managerRepository.findAll().stream().map(managerMapper::managerToManagerDTO).toList();
    }

    public ManagerDTO findById(UUID id) {
        if (managerRepository.findById(id).isPresent()) {
            return managerMapper.managerToManagerDTO(managerRepository.findById(id).get());
        } else {
            return null;
        }
    }


    public ManagerDTO update(ManagerDTO managerDto) {
        if (managerRepository.findById(managerDto.getId()).isPresent()) {
            return managerMapper.managerToManagerDTO(managerRepository.save(managerMapper.managerDTOToManager(managerDto)));
        } else {
            return null;
        }
    }

    public void delete(UUID id) {
        if (managerRepository.findById(id).isPresent()) {
            managerRepository.deleteById(id);
        }
    }

}
