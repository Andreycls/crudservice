/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrey.devtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author asemJr
 */
@Entity
@Table(name = "customer")
public class Customer {
        @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
        
	@Column(name = "name")
	private String name;
        
	@Column(name = "phone")
	private String phone;
        
        public Customer() {
	}
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
        
}