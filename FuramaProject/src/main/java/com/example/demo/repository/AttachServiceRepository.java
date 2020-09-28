package com.example.demo.repository;



import com.example.demo.model.AttachService;
import com.example.demo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService,Long> {
}
