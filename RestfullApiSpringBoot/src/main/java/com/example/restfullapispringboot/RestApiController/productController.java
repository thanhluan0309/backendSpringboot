package com.example.restfullapispringboot.RestApiController;

import com.example.restfullapispringboot.model.category;
import com.example.restfullapispringboot.model.product;
import com.example.restfullapispringboot.service.categoryService;
import com.example.restfullapispringboot.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class productController {
    @Autowired
    productService pService;

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<List<product>> listAllproduct(){
        List<product> listproduct= pService.findAll();
        if(listproduct.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<product>>(listproduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public product findOneproductBy_id(@PathVariable("id") long id){
        product p= pService.getOne(id);
        if(p == null) {
            ResponseEntity.notFound().build();
        }
        return p;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<product> updateContact(@PathVariable(value = "id") Long contactId,
                                                  @RequestBody product productForm) {
        product contact = pService.getOne(contactId);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }
        contact.setProductName(productForm.getProductName());

        contact.setCategoryId(productForm.getCategoryId());

        contact.setQuality(productForm.getQuality());


        product updatedproduct = pService.save(contact);
        return ResponseEntity.ok(updatedproduct);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<product> deleteContact(@PathVariable(value = "id") Long id) {
        product contact = pService.getOne(id);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }

        pService.delete(contact);
        return ResponseEntity.ok().build();
    }
}
