package com.example.security.demo_sercurity_2.dao;

import com.example.security.demo_sercurity_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
