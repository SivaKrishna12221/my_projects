package com.siva.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.entity.Project;

public interface IProjectRepo extends JpaRepository<Project, Integer>{

	
}
