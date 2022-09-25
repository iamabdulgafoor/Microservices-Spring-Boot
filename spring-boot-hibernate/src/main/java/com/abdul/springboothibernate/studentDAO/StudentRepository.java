package com.abdul.springboothibernate.studentDAO;

import com.abdul.springboothibernate.studentto.StudentTo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentTo, Long> {
}
