package com.kunal.CRUD_Operations.repository;

import com.kunal.CRUD_Operations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
