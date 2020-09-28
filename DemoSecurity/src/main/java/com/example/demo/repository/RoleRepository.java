package com.example.demo.repository;


import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String role_name);
}
