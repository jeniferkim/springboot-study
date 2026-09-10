package com.example.springbootstudy.common.exception;

import com.example.springbootstudy.savedroute.exception.SavedRouteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // C가 처리 과정 중에 SavedRouteNotFoundException가 발생하면 이 메서드가 그 예외를 처리해라
    @ExceptionHandler(SavedRouteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSavedRouteNotFound(
            SavedRouteNotFoundException e
    ) {
        ErrorResponse response = new ErrorResponse(
                404,
                e.getMessage()
        );

        return ResponseEntity // 에러 응답에서 HTTP Status + Body 둘 다 직접 정하고 싶을 때
                .status(HttpStatus.NOT_FOUND) // 404
                .body(response); // ErrorResponse
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException e
    ) {
        ErrorResponse response = new ErrorResponse(
                400,
                "Invalid request"
        );

        return ResponseEntity
                .badRequest()
                .body(response);
    }
}