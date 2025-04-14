package com.nsyncsolutions.pedidex.controller;

import com.nsyncsolutions.pedidex.dto.ProductDTO;
import com.nsyncsolutions.pedidex.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO dto = productService.create(productDTO);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ProductDTO>> addProducts(@RequestBody List<ProductDTO> productDTOs) {
        List<ProductDTO> dtos = productService.createAll(productDTOs);
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProduct() {
        List<ProductDTO> all = productService.findAll();
        return ResponseEntity.ok().body(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable UUID id) {
        ProductDTO dto = productService.update(productDTO, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
