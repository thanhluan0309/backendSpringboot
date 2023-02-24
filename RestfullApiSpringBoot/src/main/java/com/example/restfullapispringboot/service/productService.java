package com.example.restfullapispringboot.service;

import com.example.restfullapispringboot.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productService extends JpaRepository<product,Long> {
}
