package com.ssafit.ccachi.board.model.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board")
@RequiredArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "commentCount")
    private Long commentCount;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Builder
    protected Board(String content, Long comment_count, Long user_id) {
        this.content = content;
        this.commentCount = comment_count;
        this.userId = user_id;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comment_count=" + commentCount +
                ", user_id=" + userId +
                ", createdAt=" + createdAt +
                '}';
    }
}