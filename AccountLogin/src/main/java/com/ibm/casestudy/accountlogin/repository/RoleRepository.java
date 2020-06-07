package com.ibm.casestudy.accountlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ibm.casestudy.accountlogin.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(@Param("role") String role);
}
