package com.yangli.companiescrud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yangli.companiescrud.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);
}
