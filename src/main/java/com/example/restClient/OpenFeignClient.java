package com.example.restClient;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "restClient", url = "${name.service.url}")
public interface OpenFeignClient {
    @GetMapping("/products")
    ResponseEntity<ProductsDTO> getProducts();

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDTO> getProduct(@PathVariable Long id);

    @PostMapping("/products")
    ResponseEntity<ProductDTO> postProduct(ProductDTO productDTO);

    @PutMapping("/products/{id}")
    ResponseEntity<ProductDTO> putProduct(@PathVariable Long id, ProductDTO productDTO);

    @DeleteMapping(value = "/products/{id}", produces = { "application/json" })
    ResponseEntity<JsonNode> deleteProduct(@PathVariable Long id);
}

