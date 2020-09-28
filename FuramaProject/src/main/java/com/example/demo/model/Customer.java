package com.example.demo.model;

import com.example.demo.validate.PhoneNumber;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String birth;
   // @Pattern(regexp = "[\\d]{9}",message = "must be a number and length =9 ")
    private String cmnd;
    @PhoneNumber
    private String phone;
    private String email;
    private String address;
    @OneToMany(mappedBy="customer")
    private List<Contact> contactsList;
    public Long getId() {
        return id;
    }

    public List<Contact> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(CustomerType customerType) {
        CustomerType = customerType;
    }

    @ManyToOne
    @JoinColumn(name = "id_customer_type")
    private CustomerType CustomerType;
}
