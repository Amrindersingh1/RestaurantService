package com.restaurant.app.restaurantservice.exception;

import com.restaurant.app.restaurantservice.dto.ExceptionDto;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestaurantExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validationErrorHandler(MethodArgumentNotValidException ex){

        ExceptionDto exceptionDto = new ExceptionDto("Bad Request","com.restaurantservice.request.body.invalid", "Validation error in request body");

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            ExceptionDto.ExceptionDetails details = exceptionDto.new ExceptionDetails(fieldName, errorMessage);
            exceptionDto.getDetails().add(details);
        });

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundErrorHandler(NotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setError("Not Found");
        exceptionDto.setCode("com.restaurantservice.entity.notfound");
        exceptionDto.setMessage(ex.getMessage());
        return new ResponseEntity(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity invalidRequestBodyErrorHandler(HttpMessageNotReadableException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setError("Bad Request");
        exceptionDto.setCode("com.restaurantservice.request.body.invalid");
        exceptionDto.setMessage("Request body is invalid.");
        return new ResponseEntity(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity invalidRequestBodyErrorHandler(Exception ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setError("Internal Server error");
        exceptionDto.setCode("com.restaurantservice.internal.server.error");
        exceptionDto.setMessage(ex.getMessage());
        return new ResponseEntity(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
