package com.siva.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.entity.Admin;

public interface IAdminRepo extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByUsernameAndPassword(String username,String password);
}
