package com.example.restfullapispringboot.service;

import com.example.restfullapispringboot.model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryService extends JpaRepository<category, Long> {

}
