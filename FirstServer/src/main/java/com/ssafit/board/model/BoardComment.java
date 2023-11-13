package com.ssafit.board.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boardComment")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    // 보드 번호랑 일치 시켜야함-> 외래키
    // 나중에 DB 쿼리문 작성시 해당 보드 삭제되면 댓글들도 전부 같이 삭제될 수 있도록 할 것
    @Column(name = "board_no")
    private Integer boardNo;

    @Column(name = "user_id")
    private String userId;

    @Column(name="comment")
    private String comment;

    @Column(name = "created_time")
    @CreationTimestamp
    private Date createdTime;


}
