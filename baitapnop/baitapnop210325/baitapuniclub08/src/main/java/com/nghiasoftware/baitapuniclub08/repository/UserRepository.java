package com.nghiasoftware.baitapuniclub08.repository;

import com.nghiasoftware.baitapuniclub08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
