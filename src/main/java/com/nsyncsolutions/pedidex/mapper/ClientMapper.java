package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.ClientDTO;
import com.nsyncsolutions.pedidex.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PhoneMapper.class, AddressMapper.class})
public interface ClientMapper {

    ClientDTO clientToClientDTO(Client client);

    Client clientDTOToClient(ClientDTO clientDTO);

}