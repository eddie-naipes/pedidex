package com.nsyncsolutions.pedidex.mapper;

import com.nsyncsolutions.pedidex.dto.ProductDTO;
import com.nsyncsolutions.pedidex.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);
}
