package com.example.demo.exception;

import com.example.demo.controller.ExceptionController;
import com.example.demo.entity.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Hens
 * @date : 2019/9/18 21:33
 */
@ControllerAdvice(assignableTypes = {ExceptionController.class})
@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalAccessException("参数错误"));
    ErrorResponse errorResponse = new ErrorResponse(new ResourceNotFoundException("sorry, the resource not found"));

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        if(e instanceof IllegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        }else if(e instanceof ResourceNotFoundException){
            return ResponseEntity.status(404).body(errorResponse);
        }
        return null;
    }
}
