package com.sphong.sessionexample.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPw;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Builder
    public User(String userId, String userPw, Role role) {
        this.userId = userId;
        this.userPw = userPw;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
