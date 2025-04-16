package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.StudentPojo;

public interface StudentRepo extends JpaRepository<StudentPojo, Integer> {

}
