package com.example.springbootstudy.savedroute.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateSavedRouteRequest {
    @NotBlank
    private String title;

    @PositiveOrZero
    private Integer savingAmount;

    public String getTitle() {
        return title;
    }

    public Integer getSavingAmount() {
        return savingAmount;
    }
}
