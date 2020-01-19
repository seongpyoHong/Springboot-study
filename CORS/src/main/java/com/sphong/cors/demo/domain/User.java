package com.sphong.cors.demo.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "USERS")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, name = "name")
    private String userName;

    @Column (nullable = false, name = "location")
    private String location;

    @Column (nullable = false, name = "menu")
    private String menu;

    @Builder
    public User (String userName, String location, String menu) {
        this.userName = userName;
        this.location = location;
        this.menu = menu;
    }
}
