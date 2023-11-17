package com.ssafit.ccachi.board.model.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateBoardRequestDto {
    private Long id;
    @NonNull
    private Long user_id;
    @NonNull
    private String contents;
    @NonNull
    private String title;

    private String url;

    @Override
    public String toString() {
        return "CreateBoardRequestDto{" +
                "user_id=" + user_id +
                ", contents='" + contents + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
