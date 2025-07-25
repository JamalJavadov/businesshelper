package com.example.businesshelper.controller;

import com.example.businesshelper.model.dto.ProductRequestDto;
import com.example.businesshelper.model.dto.ProductResponseDto;
import com.example.businesshelper.model.dto.ProductUpdateDto;
import com.example.businesshelper.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.create(productRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductResponseDto> update(@RequestBody ProductUpdateDto productUpdateDto){
        return ResponseEntity.ok(productService.update(productUpdateDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponseDto> get(@PathVariable long id){
        return ResponseEntity.ok(productService.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }


}
