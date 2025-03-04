package com.nghiasoftware.demojpa08.repository;

import com.nghiasoftware.demojpa08.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
