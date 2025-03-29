package com.nghiasoftware.uniclub08.services;

import org.springframework.web.multipart.MultipartFile;

public interface ProductServices {
    void insertProduct(MultipartFile file);
}
