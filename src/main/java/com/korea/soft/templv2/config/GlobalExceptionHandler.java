package com.korea.soft.templv2.config;

import com.korea.soft.templv2.domain.common.CommonDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// Exception을 낚아채기
@ControllerAdvice //어디서든 Except을 받기위한 어노테이션
@RestController
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public CommonDto<String> handlException(Exception e){
//        return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public CommonDto<String> handleArgmentException(IllegalArgumentException e){
        return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public CommonDto<String> handleUsernameNotFoundException(UsernameNotFoundException e){
        return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }


}