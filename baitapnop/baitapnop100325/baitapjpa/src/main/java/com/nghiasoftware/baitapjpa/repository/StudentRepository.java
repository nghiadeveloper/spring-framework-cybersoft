package com.nghiasoftware.baitapjpa.repository;

import com.nghiasoftware.baitapjpa.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    List<Students> findByName(String name);
}
