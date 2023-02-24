package com.example.restfullapispringboot.RestApiController;


import com.example.restfullapispringboot.model.firstname;
import com.example.restfullapispringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/apiuser")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<firstname>> listAllContact(){
        List<firstname> listContact= userService.findAll();
        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<firstname>>(listContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public firstname findOneUserBy_id(@PathVariable("id") long id){
        firstname f= userService.getOne(id);
        if(f == null) {
            ResponseEntity.notFound().build();
        }
        return f;
    }

    @RequestMapping(value = "/user/", method = RequestMethod.PUT)
    public ResponseEntity<firstname> updateContact(@PathVariable(value = "id") Long contactId,
                                                  @RequestBody firstname contactForm) {
        firstname contact = userService.getOne(contactId);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }
        contact.setFirstname(contactForm.getFirstname());

        contact.setFirstname(contactForm.getFirstname());

        contact.setAges(contactForm.getAges());

        firstname updatedContact = userService.save(contact);
        return ResponseEntity.ok(updatedContact);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<firstname> deleteContact(@PathVariable(value = "id") Long id) {
        firstname contact = userService.getOne(id);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }

        userService.delete(contact);
        return ResponseEntity.ok().build();
    }
}
