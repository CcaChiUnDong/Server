package com.ssafit.ccachi.user.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Builder
    protected User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
