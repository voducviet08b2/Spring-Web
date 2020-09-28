package com.example.demo.repository;



import com.example.demo.model.Contact;
import com.example.demo.model.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailContactRepository extends JpaRepository<ContactDetail,Long> {
}
