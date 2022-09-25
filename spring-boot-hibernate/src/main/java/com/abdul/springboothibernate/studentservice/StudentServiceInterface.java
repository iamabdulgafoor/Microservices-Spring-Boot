package com.abdul.springboothibernate.studentservice;

import com.abdul.springboothibernate.studentto.StudentTo;

import java.util.List;

public interface StudentServiceInterface {
    public abstract StudentTo saveOrUpdate(StudentTo std);
    public abstract List<StudentTo> getAllStudents();
    public void deleteStd(Long id);
    void updateStd(StudentTo student);

    StudentTo getStdById(Long stdId);
}
