package com.nghiasoftware.uniclub08.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServices {
    void save(MultipartFile file);
    Resource load(String fileName);
}
