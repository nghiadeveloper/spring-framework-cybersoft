package com.cybersoft.uniclub08.respository;

import com.cybersoft.uniclub08.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {
}
