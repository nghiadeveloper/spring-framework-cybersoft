package com.nghiasoftware.demoapi08.controller;

import com.nghiasoftware.demoapi08.entity.BaiVietEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baiviet")
public class BaiVietController {

    @GetMapping
    public ResponseEntity<BaiVietEntity> getAllBaiViet() {
        BaiVietEntity baiVietEntity = new BaiVietEntity();
        baiVietEntity.setTieuDe("Tiêu đề");
        baiVietEntity.setNoiDung("Nội dung");

        return new ResponseEntity<>(baiVietEntity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insertBaiViet() {
        return new ResponseEntity<>("Insert BaiViet", HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<String> updateBaiViet() {
        return new ResponseEntity<>("Update BaiViet", HttpStatus.OK);
    }

}
