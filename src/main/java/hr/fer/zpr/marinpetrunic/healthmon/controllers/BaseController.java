package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.models.RestError;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public abstract class BaseController {

    public static final String ALLOW_ALL = "permitAll";
    public static final String DENY_ALL = "denyAll";
    public static final String USER = "hasAuthority('USER')";


    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestError> handleException(Exception e) {
        return getRestErrorResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR, "Server error!");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RestError> handleException(ResourceNotFoundException e) {
        return getRestErrorResponseEntity(e, HttpStatus.NOT_FOUND, "Requested resource not found!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestError> handleException(MethodArgumentNotValidException e) {
        ResponseEntity<RestError> response = getRestErrorResponseEntity(e, HttpStatus.BAD_REQUEST, "Request validation failed!");
        response.getBody().setErrors(e.getBindingResult().getAllErrors());
        return response;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<RestError> handleException(AccessDeniedException e) {
        return getRestErrorResponseEntity(e, HttpStatus.UNAUTHORIZED, "Authorization needed to access this resource!");
    }

    private ResponseEntity<RestError> getRestErrorResponseEntity(Exception e, HttpStatus status, String message) {
        RestError error = new RestError();
        error.setError(status.getReasonPhrase());
        error.setMessage(message);
        error.setException(e.getClass().getName());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<RestError>(error, status);
    }

    protected UserModel getLoggedUser() {
        return (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
