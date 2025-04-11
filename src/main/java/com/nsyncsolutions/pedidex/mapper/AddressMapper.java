package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.AddressDTO;
import com.nsyncsolutions.pedidex.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO addressToAddressDTO(Address address);
    Address addressDTOToAddress(AddressDTO addressDTO);
}