package com.yangli.companiescrud.services;

import com.yangli.companiescrud.entities.Company;

public interface CompanyService {

    Company create(Company company);

    Company readByName(String name);

    Company update(Company company, String name);

    void delete(String name);

}
