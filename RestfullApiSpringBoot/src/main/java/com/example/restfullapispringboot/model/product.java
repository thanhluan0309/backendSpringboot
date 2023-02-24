package com.example.restfullapispringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class product implements Serializable {
    @Id
    private Long id;
    private String ProductName;
    private int quality;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long CategoryId;

    public product() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public product(Long id, String productName, int quality, Long categoryId) {
        this.id = id;
        ProductName = productName;
        this.quality = quality;
        CategoryId = categoryId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }
}
