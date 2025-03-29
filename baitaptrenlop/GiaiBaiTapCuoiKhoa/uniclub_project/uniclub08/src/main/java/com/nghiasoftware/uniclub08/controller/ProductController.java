package com.nghiasoftware.uniclub08.controller;

import com.nghiasoftware.uniclub08.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public ResponseEntity<?> insertProduct(@RequestParam MultipartFile file) {
        productServices.insertProduct(file);
        return ResponseEntity.ok("Hello insert product");
    }

}
