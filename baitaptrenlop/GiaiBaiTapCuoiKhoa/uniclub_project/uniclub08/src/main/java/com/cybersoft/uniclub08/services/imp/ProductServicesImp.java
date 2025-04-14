package com.cybersoft.uniclub08.services.imp;

import com.cybersoft.uniclub08.dto.ProductDTO;
import com.cybersoft.uniclub08.entity.Color;
import com.cybersoft.uniclub08.entity.Product;
import com.cybersoft.uniclub08.entity.Size;
import com.cybersoft.uniclub08.entity.Variant;
import com.cybersoft.uniclub08.exception.InsertException;
import com.cybersoft.uniclub08.respository.ProductRepository;
import com.cybersoft.uniclub08.respository.VariantRepository;
import com.cybersoft.uniclub08.services.FileServices;
import com.cybersoft.uniclub08.services.ProductServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServicesImp implements ProductServices {

    @Autowired
    private FileServices fileServices;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VariantRepository variantRepository;


    @Transactional
    @Override
    public void insertProduct(MultipartFile file, String name, String desc, double price, int idSize, int idColor, int quantity) {
        try{
            Product product = new Product();
            product.setName(name);
            product.setDescription(desc);
            product.setPrice(price);

            Product productInserted = productRepository.save(product);

            Color color = new Color();
            color.setId(idColor);

            Size size = new Size();
            size.setId(idSize);

            Variant variant = new Variant();
            variant.setProduct(productInserted);
            variant.setColor(color);
            variant.setSize(size);
            variant.setQuantity(quantity);
            variant.setImages(file.getOriginalFilename());

            fileServices.save(file);
            variantRepository.save(variant);
        }catch (Exception e){
            throw new InsertException("Product : " + e.getMessage());
        }


    }

    @Override
    public List<ProductDTO> getAllProducts(int pageNumber, int pageSize) {
        //StreamApi :
        //map <=> foreach
        Pageable page = PageRequest.of(pageNumber,pageSize);
        List<ProductDTO> productDTOs = productRepository.findAll(page).stream().map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());

            if(!product.getVariants().isEmpty()){
                productDTO.setUrlImage("http://localhost:8080/file/" + product.getVariants().get(0).getImages());
            }
            return productDTO;
        }).toList();

        return productDTOs;
    }
}
