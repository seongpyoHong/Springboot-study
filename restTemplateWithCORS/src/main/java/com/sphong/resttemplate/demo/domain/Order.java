package com.sphong.resttemplate.demo.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String menu;

    @Column(nullable = false)
    private String location;

    @Builder
    public Order(String userName, String menu, String location) {
        this.userName = userName;
        this.menu = menu;
        this.location = location;
    }
}
