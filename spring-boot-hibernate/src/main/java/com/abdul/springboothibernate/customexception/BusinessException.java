package com.abdul.springboothibernate.customexception;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BusinessException extends  RuntimeException{

    public String errorCode;
    public String errorMessage;

}
