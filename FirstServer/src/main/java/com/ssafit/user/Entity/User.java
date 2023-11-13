package com.ssafit.user.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "userId")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "grade")
    private String grade;

    @Column(name = "email")
    private String email;

    @Column(name = "created_time")
    @CreationTimestamp
    private Date createdTime;

    @PrePersist
    public void prePersist() {
        createdTime = Timestamp.valueOf(LocalDateTime.now());
        this.grade = "normal";

    }

    @Builder
    protected User(String name, String userId, String password, String phone, String email) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
