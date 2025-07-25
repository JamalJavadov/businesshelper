package com.example.businesshelper.controller;


import com.example.businesshelper.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageUploadController {

    private final ImageUploadService imageUploadService;


    @PostMapping("/upload-meal/{id}")
    public ResponseEntity<String> uploadMealImage(@RequestParam("file") MultipartFile file,@PathVariable("id") long id){
        return ResponseEntity.ok(imageUploadService.uploadImageMeal(file,id));
    }

}
