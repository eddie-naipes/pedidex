package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.OrderDTO;
import com.nsyncsolutions.pedidex.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderedItemMapper.class, ClientMapper.class})
public interface OrderMapper {
    OrderDTO orderToOrderDTO(Order order);
    Order orderDTOToOrder(OrderDTO orderDTO);
}