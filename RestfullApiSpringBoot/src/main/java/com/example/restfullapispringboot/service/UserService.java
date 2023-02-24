package com.example.restfullapispringboot.service;

import com.example.restfullapispringboot.model.firstname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserService extends JpaRepository<firstname, Long> {

}
