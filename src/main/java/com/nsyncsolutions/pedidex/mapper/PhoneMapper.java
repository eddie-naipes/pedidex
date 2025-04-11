package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.PhoneDTO;
import com.nsyncsolutions.pedidex.model.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    PhoneDTO phoneToPhoneDTO(Phone phone);
    Phone phoneDTOToPhone(PhoneDTO phoneDTO);
}