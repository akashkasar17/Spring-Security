package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entities.StudentEntity;

//@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

}
