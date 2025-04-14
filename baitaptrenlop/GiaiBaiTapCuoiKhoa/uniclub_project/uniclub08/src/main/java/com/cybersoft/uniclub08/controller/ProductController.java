package com.cybersoft.uniclub08.controller;

import com.cybersoft.uniclub08.payload.response.BaseResponse;
import com.cybersoft.uniclub08.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public ResponseEntity<?> insertProduct(@RequestParam MultipartFile file,
                                           String name,
                                           String desc,
                                           double price,
                                           int idSize,
                                           int idColor,
                                           int quantity
                                           ) {

        productServices.insertProduct(file,name,desc,price,idSize,idColor,quantity);

        return ResponseEntity.ok("Hello insert product");
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(@RequestParam int pageNumber, @RequestParam int pageSize) {

        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setData(productServices.getAllProducts(pageNumber,pageSize));

        return ResponseEntity.ok(response);
    }

}
