package com.example.springbootstudy.savedroute.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateSavedRouteRequest {

    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }
}