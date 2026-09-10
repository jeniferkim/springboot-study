package com.example.springbootstudy.savedroute;

import com.example.springbootstudy.user.User;
import jakarta.persistence.*;

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
    public SavedRoute(String title, Integer savingAmount, User user) {
        this.title = title;
        this.savingAmount = savingAmount;
        this.user = user;
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

    // 얘는 setter처럼 값을 바꾸는 역할을 하지만 setTitle보다 의미 있는 이름을 쓴 것임
    public void changeTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
