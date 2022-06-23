/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrey.devtest.controller;

import com.andrey.devtest.model.Customer;
import com.andrey.devtest.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sembiring
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    CustomerRepository customerRepository;
    
  @PostMapping("/customers")
  public ResponseEntity<Customer> createTutorial(@RequestBody Customer customer) {
    try {
      Customer customerOrder = customerRepository
          .save(new Customer(customer.getName(), customer.getPhone()));
      return new ResponseEntity<>(customerOrder, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PutMapping("/customers/{id}")
  public ResponseEntity<Customer> updateTutorial(@PathVariable("id") long id, @RequestBody Customer customer) {
    Optional<Customer> customerData =  customerRepository.findById(id);
    if (customerData.isPresent()) {
      Customer customerDataObject = customerData.get();
      customerDataObject.setName(customer.getName());
      customerDataObject.setPhone(customer.getPhone());
      return new ResponseEntity<>(customerRepository.save(customerDataObject), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/customers/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      customerRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    try {
      List<Customer> customers = new ArrayList<Customer>();
      customerRepository.findAll().forEach(customers::add);
      
      if (customers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(customers, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
