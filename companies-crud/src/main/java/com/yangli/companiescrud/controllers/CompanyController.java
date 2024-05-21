package com.yangli.companiescrud.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangli.companiescrud.entities.Company;
import com.yangli.companiescrud.services.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "get a company given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable final String name) {
        log.info("GET: company {}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @Operation(summary = "post in DB a company given a company from body")
    @PostMapping()
    public ResponseEntity<Company> post(@RequestBody final Company company) {
        log.info("POST: company {}", company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
    }

    @Operation(summary = "update in DB a company given a company from body")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody final Company company, @PathVariable final String name) {
        log.info("PUT: company {}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

    @Operation(summary = "delete in DB a company given a company from name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable final String name) {
        log.info("DELETE: company {}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
