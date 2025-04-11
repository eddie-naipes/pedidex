package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.ManagerDTO;
import com.nsyncsolutions.pedidex.model.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    ManagerDTO managerToManagerDTO(Manager manager);

    Manager managerDTOToManager(ManagerDTO managerDTO);
}
