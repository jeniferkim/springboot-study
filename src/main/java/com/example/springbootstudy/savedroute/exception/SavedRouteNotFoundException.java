package com.example.springbootstudy.savedroute.exception;

public class SavedRouteNotFoundException
        extends RuntimeException { // 실행 중 발생하는 예외의 대표 타입

    public SavedRouteNotFoundException(Long id) {
        super("SavedRoute not found. id=" + id);
    }
}