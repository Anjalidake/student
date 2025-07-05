package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.StudentPojo;
// ---------------------------
////////////////// this is for merge request/ PR
public interface StudentRepo extends JpaRepository<StudentPojo, Integer> {

}
