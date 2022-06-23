/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrey.devtest.repository;

import com.andrey.devtest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author asemJr
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
