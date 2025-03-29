package com.nghiasoftware.uniclub08.services.imp;

import com.nghiasoftware.uniclub08.services.FileServices;
import com.nghiasoftware.uniclub08.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServicesImp implements ProductServices {

    @Autowired
    private FileServices fileServices;

    @Override
    public void insertProduct(MultipartFile file) {
        fileServices.save(file);
    }

}
