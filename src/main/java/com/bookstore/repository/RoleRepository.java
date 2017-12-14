package com.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findRoleByName( String name );
	List<Role> findAll();
	
}
