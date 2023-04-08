package com.musala.drone.domain.exception;

import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class, basePackages = "com.musala.drone.application")
public class OfflineBillingExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<JSONObject> handleCustomException(CustomException ex) {

        JSONObject statusResponse = new JSONObject();
        JSONObject response = new JSONObject();

        response.put("message", ex.message);
        response.put("code", ex.code);
        statusResponse.put("status", response);

        return new ResponseEntity<>(statusResponse, HttpStatus.OK);

    }

}
