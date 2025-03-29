package com.nghiasoftware.uniclub08.repository;

import com.nghiasoftware.uniclub08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // SELECT: find
    // WHERE: By
    // Kiểu dữ liệu Optional: Xử lý, tránh thiếu sót khi xử lý null

    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);

}
