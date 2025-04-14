package com.nsyncsolutions.pedidex.service;

import com.nsyncsolutions.pedidex.dto.ManagerDTO;
import com.nsyncsolutions.pedidex.mapper.ManagerMapper;
import com.nsyncsolutions.pedidex.model.Manager;
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

        Manager manager = managerMapper.managerDTOToManager(managerDto);
        manager.setUsername(generateUserName(managerDto.getFirstName(), managerDto.getLastName()));
        System.out.println("Manager username: " + manager.getUsername());
        System.out.println("Manager: " + manager.toString());
        return managerMapper.managerToManagerDTO(managerRepository.save(manager));
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
            managerDto.setUsername(generateUserName(managerDto.getFirstName(), managerDto.getLastName()));
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


    private String generateUserName(String firstName, String lastName) {
        String firstPart = firstName.substring(0, 1).toLowerCase();
        String lastPart = lastName.toLowerCase();
        return firstPart.concat(".").concat(lastPart);
    }

}
