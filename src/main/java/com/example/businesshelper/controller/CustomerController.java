package com.example.businesshelper.controller;

import com.example.businesshelper.model.dto.CustomerRequestDto;
import com.example.businesshelper.model.dto.CustomerResponseDto;
import com.example.businesshelper.model.dto.CustomerUpdateDto;
import com.example.businesshelper.service.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto customerRequestDto){
        return ResponseEntity.ok(customerService.create(customerRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerUpdateDto customerUpdateDto){
        return ResponseEntity.ok(customerService.update(customerUpdateDto));
    }

    @GetMapping("/get/{instagramName}")
    public ResponseEntity<CustomerResponseDto> get(@PathVariable String instagramName){
        return ResponseEntity.ok(customerService.get(instagramName));
    }


}
