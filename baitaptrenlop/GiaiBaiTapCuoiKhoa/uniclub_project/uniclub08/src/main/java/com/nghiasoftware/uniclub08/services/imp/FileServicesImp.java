package com.nghiasoftware.uniclub08.services.imp;

import com.nghiasoftware.uniclub08.services.FileServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServicesImp implements FileServices {

    @Value("${file.upload}")
    private String root;

    @Override
    public void save(MultipartFile file) {
        try {
            Path rootPath = Paths.get(root);
            if(!Files.exists(rootPath)) {
                Files.createDirectory(rootPath);
            }
            Files.copy(file.getInputStream(), rootPath.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Lỗi upload: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path pathFile = Paths.get(root).resolve(fileName);
            Resource resource = new UrlResource(pathFile.toUri());
            if(resource.exists()) {
                return resource;
            }
        } catch (Exception e) {
            System.out.println("Lỗi load: " + e.getMessage());
        }
        return null;
    }

}
