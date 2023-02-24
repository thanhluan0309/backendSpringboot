package com.example.restfullapispringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class firstname implements Serializable {
    private Long id;
    private String firstname;
    private String lastname;
    private Long ages;

    public firstname( String firstname, String lastname, Long ages,Long id) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ages = ages;
    }

    public firstname() {

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getAges() {
        return ages;
    }

    public void setAges(Long ages) {
        this.ages = ages;
    }
}
