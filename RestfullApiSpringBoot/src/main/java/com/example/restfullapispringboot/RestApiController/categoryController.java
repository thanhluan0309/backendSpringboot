package com.example.restfullapispringboot.RestApiController;

import com.example.restfullapispringboot.model.category;
import com.example.restfullapispringboot.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class categoryController {
    @Autowired
    categoryService cService;

    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<category>> listAllcategory(){
        List<category> listcategory= cService.findAll();
        if(listcategory.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<category>>(listcategory, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public category findOnecategoryBy_id(@PathVariable("id") long id){
        category c= cService.getOne(id);
        if(c == null) {
            ResponseEntity.notFound().build();
        }
        return c;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<category> updateContact(@PathVariable(value = "id") Long contactId,
                                                   @RequestBody category categoryForm) {
        category contact = cService.getOne(contactId);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }
        contact.setName(categoryForm.getName());

        category updatedContact = cService.save(contact);
        return ResponseEntity.ok(updatedContact);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<category> deleteContact(@PathVariable(value = "id") Long id) {
        category contact = cService.getOne(id);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }

        cService.delete(contact);
        return ResponseEntity.ok().build();
    }
}
