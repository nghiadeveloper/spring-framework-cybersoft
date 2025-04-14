package com.cybersoft.uniclub08.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private double price;
    private String information;

    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "product")
    private List<Variant> variants;
}
