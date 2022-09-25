package com.abdul.springboothibernate.studentcontroller;

import com.abdul.springboothibernate.customexception.BusinessException;
import com.abdul.springboothibernate.customexception.ControllerException;
import com.abdul.springboothibernate.studentservice.StudentServiceInterface;
import com.abdul.springboothibernate.studentto.StudentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student/v1")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveOrUpdate(@RequestBody StudentTo std) {
            StudentTo savedStd = studentService.saveOrUpdate(std);
            return new ResponseEntity<StudentTo>(savedStd, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllStdDetails() {
           List<StudentTo> result = studentService.getAllStudents();
            return new ResponseEntity<List<StudentTo>>(result, HttpStatus.OK);
         }

    @DeleteMapping("{Id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long Id) {
        studentService.deleteStd(Id);
        return new ResponseEntity<String>("Student with " + Id + " deleted Successfully", HttpStatus.ACCEPTED);
    }

    @PutMapping
    public void updateStd(@RequestBody StudentTo student) {
        studentService.updateStd(student);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getStdById(@PathVariable("Id") Long stdId) {

            StudentTo stdRetrieved = studentService.getStdById(stdId);
            return new ResponseEntity<>(stdRetrieved, HttpStatus.OK);
    }
}