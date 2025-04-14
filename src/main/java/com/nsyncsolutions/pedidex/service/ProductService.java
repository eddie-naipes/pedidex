package com.nsyncsolutions.pedidex.service;

import com.nsyncsolutions.pedidex.dto.ProductDTO;
import com.nsyncsolutions.pedidex.mapper.ProductMapper;
import com.nsyncsolutions.pedidex.model.Product;
import com.nsyncsolutions.pedidex.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductDTO create(ProductDTO productDto) {
        Product product = productMapper.productDTOToProduct(productDto);
        return productMapper.productToProductDTO(productRepository.save(product));
    }

    public List<ProductDTO> createAll(List<ProductDTO> productDtos) {
        List<Product> products = productDtos.stream().map(productMapper::productDTOToProduct).toList();
        products = productRepository.saveAll(products);
        return products.stream().map(productMapper::productToProductDTO).toList();
    }

    public ProductDTO findById(UUID id) {
        if (productRepository.findById(id).isPresent()) {
            return productMapper.productToProductDTO(productRepository.findById(id).get());
        } else {
            return null;
        }
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(productMapper::productToProductDTO).toList();
    }

    public ProductDTO update(ProductDTO productDto, UUID id) {
        if (productRepository.findById(id).isPresent()) {
            productDto.setId(id);
            return productMapper.productToProductDTO(productRepository.save(productMapper.productDTOToProduct(productDto)));
        } else {
            return null;
        }
    }

    public void delete(UUID id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }


}
