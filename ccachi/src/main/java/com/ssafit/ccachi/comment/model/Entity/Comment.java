package com.ssafit.ccachi.comment.model.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter @Setter @Builder
@RequiredArgsConstructor
public class Comment {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "board_id")
    private Long boardId;
    @Column(name = "user_id")
    private Long userId;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_at=" + createdAt +
                ", board_id=" + boardId +
                ", user_id=" + userId +
                '}';
    }

    @Builder
    protected Comment(Long id, String content, LocalDateTime created_at, Long board_id,Long user_id) {
        this.id = id;
        this.content = content;
        this.createdAt = created_at;
        this.boardId = board_id;
        this.userId = user_id;
    }
}

