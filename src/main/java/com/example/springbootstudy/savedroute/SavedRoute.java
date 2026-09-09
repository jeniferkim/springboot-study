package com.example.springbootstudy.savedroute;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 이 클래스는 DB와 연결해서 관리할 Entity야
public class SavedRoute {
    @Id // 이 필드가 Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id값을 자동 생성
    private Long id;

    private String title;

    private Integer savingAmount;

    // JPA용 기본 생성자
    protected SavedRoute() {
    }

    // 이건 데이터 직접 생성하기 위한 생성자
    public SavedRoute(String title, Integer savingAmount) {
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
