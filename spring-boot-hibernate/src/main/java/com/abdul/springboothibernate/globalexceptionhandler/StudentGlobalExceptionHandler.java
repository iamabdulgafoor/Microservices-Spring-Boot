package com.abdul.springboothibernate.globalexceptionhandler;

import com.abdul.springboothibernate.customexception.EmptyNameException;
import com.abdul.springboothibernate.customexception.NoElementFoundException;
import com.abdul.springboothibernate.customexception.NoRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyNameException.class)
    public ResponseEntity<String> handleEmptyNameException(EmptyNameException e){
        return new ResponseEntity<>("Input Name sent is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<String> handleNoRecordFoundException(NoRecordFoundException e){
        return new ResponseEntity<String>("No Records found for the request in the DB",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<String> handleNoSuchMethodException(NoSuchMethodException e){
        return new ResponseEntity<String>("No Such element present in the our records",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoElementFoundException.class)
    public ResponseEntity<String> handleNoElementFoundException(NoElementFoundException e){
        return new ResponseEntity<String>(e.getErrorMessage(),HttpStatus.NOT_FOUND);

    }

}
