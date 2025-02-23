package com.nghiasoftware.demospringboot08.config;

import com.nghiasoftware.demospringboot08.entity.NhanVien;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NhanVienConfig {

    // Khai báo class gán sẵn giá trị và đưa lên IOC lưu trữ
    @Bean
    public NhanVien setNhanVien() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setUsername("Nguyen Hieu Nghia");
        return nhanVien;
    }
}
