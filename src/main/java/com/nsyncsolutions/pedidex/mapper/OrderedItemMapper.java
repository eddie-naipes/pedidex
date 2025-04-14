package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.OrderedItemDTO;
import com.nsyncsolutions.pedidex.model.OrderedItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderedItemMapper {
    OrderedItemDTO orderedItemToOrderedItemDTO(OrderedItem orderedItem);

    OrderedItem orderedItemDTOToOrderedItem(OrderedItemDTO orderedItemDTO);
}