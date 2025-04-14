package com.cybersoft.uniclub08.services;

import com.cybersoft.uniclub08.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductServices {
    void insertProduct(MultipartFile file,String name, String desc, double price, int idSize, int idColor, int quantity);
    List<ProductDTO> getAllProducts(int pageNumber, int pageSize);

}
