package com.spring.boot.security.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.security.application.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
