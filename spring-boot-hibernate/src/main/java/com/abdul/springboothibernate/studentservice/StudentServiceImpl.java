package com.abdul.springboothibernate.studentservice;

import com.abdul.springboothibernate.customexception.BusinessException;
import com.abdul.springboothibernate.customexception.EmptyNameException;
import com.abdul.springboothibernate.customexception.NoElementFoundException;
import com.abdul.springboothibernate.customexception.NoRecordFoundException;
import com.abdul.springboothibernate.studentDAO.StudentRepository;
import com.abdul.springboothibernate.studentto.StudentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentServiceInterface{

    @Autowired
    private StudentRepository studentRepository;

    public StudentTo saveOrUpdate(StudentTo std){

        if(std.getStdName().isEmpty() || std.getStdName().length() ==0) {
            throw new EmptyNameException("601", "Student name is Empty, plz send proper name");
        }
        try {
            StudentTo student = studentRepository.save(std);
            return student;
        }catch (IllegalStateException e){
            throw new BusinessException("602","Given student is null Service Layer "+e.getMessage());
        }catch(Exception e){
            throw new BusinessException("603","Unknown Error Occurred in Service Layer "+ e.getMessage());
        }
    }
    public List<StudentTo> getAllStudents(){
        List<StudentTo> stdList= null;
        try {
            stdList = studentRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("604", "Unknown Error Occurred in Service Layer while fetching from DB " + e.getMessage());
        }
         if (stdList.isEmpty()) {
             throw new NoRecordFoundException("605", "Student list is empty in the DB ");
         }
         return stdList;
    }

    public void deleteStd(Long id) {
        try {
            studentRepository.deleteById(id);
        }catch (IllegalArgumentException e){
            throw new BusinessException("606","Id sent in request is null "+e.getMessage());
        }catch (NoSuchElementException e){
            throw new BusinessException("607","There is no data for given "+id + " in the ddb "+ e.getMessage());
        }catch (Exception e){
            throw new BusinessException("608","Unknown error occurred in service layer");
        }
    }

    public void updateStd(StudentTo student) {
        studentRepository.save(student);

    }
    @Override
    public StudentTo getStdById(Long stdId) {
        try {
            return studentRepository.findById(stdId).get();
        }catch (IllegalArgumentException e){
            throw new BusinessException("609","Id sent in the request is null");
        }catch (NoSuchElementException e){
            throw new NoElementFoundException("610","Record not found in the db for "+stdId+" "+ e.getMessage());
        }catch (Exception e){
            throw new BusinessException("608","Unknown error occurred in service layer");
        }
    }
}
