package com.restaurant.app.restaurantservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDto implements Serializable {

    private String error;
    private String code;
    private String message;
    private List<ExceptionDetails> details;

    public ExceptionDto() {
        this.details = new ArrayList<>();
    }

    public ExceptionDto(String error, String code, String message) {
        this.error = error;
        this.code = code;
        this.message = message;
        this.details = new ArrayList<>();
    }

    public class ExceptionDetails implements Serializable{
        String error;
        String message;

        public ExceptionDetails(String error, String message) {
            this.error = error;
            this.message = message;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public void setDetails(List<ExceptionDetails> details) {
        this.details = details;
    }

    public List<ExceptionDetails> getDetails() {
        return details;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

