// 일부러 User 안 넣음. 프론트에 "필요한 정보"만 정의!

package com.example.springbootstudy.savedroute.dto;

public class SavedRouteResponse {

    private final Long id;
    private final String title;
    private final Integer savingAmount;

    public SavedRouteResponse(
            Long id,
            String title,
            Integer savingAmount
    ) {
        this.id = id;
        this.title = title;
        this.savingAmount = savingAmount;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSavingAmount() {
        return savingAmount;
    }
}